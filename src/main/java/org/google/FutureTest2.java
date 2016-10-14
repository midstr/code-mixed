package org.google;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.SettableFuture;

/**
 * @author yaogangli
 * @date 2013-10-16 下午3:19:20
 */
public class FutureTest2<K, V> {

	private final ConcurrentMap<K, Future<? extends V>> map = new ConcurrentHashMap<K, Future<? extends V>>();

	private final ExecutorService exec = Executors.newFixedThreadPool(10);

	public V get(K key) {
		return null;
	}

	public void put(K key, V value) {

	}

	public V get(final K key, long timeoutMS, final Callable<? extends V> loadTask) throws InterruptedException,
			ExecutionException {
		V old = get(key);
		if (old != null) {
			return old;
		}
		Future<? extends V> future = getFuture(key, loadTask);
		try {
			return future.get(timeoutMS, TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
			return null;
		}
	}

	private Future<? extends V> getFuture(final K key, final Callable<? extends V> loadTask) {
		Future<? extends V> ff = map.get(key);
		if (ff != null) {
			return ff;
		}
		final SettableFuture<V> newFuture = SettableFuture.create();
		Future<? extends V> oldFuture = map.putIfAbsent(key, newFuture);
		if (oldFuture != null) {
			return oldFuture;
		}

		exec.submit(new Callable<V>() {
			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			@Override
			public V call() throws Exception {
				try {
					V result = loadTask.call();
					put(key, result);
					newFuture.set(result);
					map.remove(key);
					return result;
				} catch (Exception e) {
					newFuture.set(null);
					map.remove(key);
					throw e;
				}
			}
		});
		return newFuture;
	}
}
