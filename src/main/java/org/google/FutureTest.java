package org.google;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;

/**
 * @author yaogangli
 * @date 2013-10-16 下午3:08:03
 */
public class FutureTest<K, V> {

	private final ConcurrentMap<K, ListenableFuture<? extends V>> map = new ConcurrentHashMap<K, ListenableFuture<? extends V>>();

	private final ListeningExecutorService exec = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

	public V get(K key) {
		return null;
	}

	public void put(K key, V value) {

	}

	public V get(K key, Callable<? extends V> valueLoader, long timeoutMS) throws ExecutionException {
		V oldValue = get(key);

		if (oldValue != null) {
			return oldValue;
		}

		ListenableFuture<? extends V> future = loadValueAsync(key, oldValue, valueLoader);
		try {
			V value = Uninterruptibles.getUninterruptibly(future, timeoutMS, TimeUnit.MILLISECONDS);
			return value;
		} catch (TimeoutException e) {
			// do nothing
		}

		return oldValue;
	}

	private ListenableFuture<? extends V> loadValueAsync(final K key, final V oldValue,
			Callable<? extends V> valueLoader) throws ExecutionException {

		ListenableFuture<? extends V> future = map.get(key);
		if (future != null) {
			return future;
		}

		final SettableFuture<V> newFuture = SettableFuture.create();
		future = map.putIfAbsent(key, newFuture);
		if (future != null) {
			return future;
		}

		ListenableFuture<? extends V> listenableFuture = exec.submit(valueLoader);
		Futures.addCallback(listenableFuture, new FutureCallback<V>() {

			@Override
			public void onSuccess(V result) {
				put(key, result);
				newFuture.set(result);
				map.remove(key);
			}

			@Override
			public void onFailure(Throwable t) {
				newFuture.set(null);
				map.remove(key);
			}
		}, Executors.newSingleThreadExecutor());

		return newFuture;
	}

}
