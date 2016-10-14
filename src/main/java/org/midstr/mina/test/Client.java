package org.midstr.mina.test;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * @author yaogangli
 * @date 2013-6-18 上午11:12:17
 */
public class Client {

	private static final String HOSTNAME = "localhost";

	private static final int PORT = 12345;

	private static final long CONNECT_TIMEOUT = 30 * 1000L; // 30 seconds

	// Set this to false to use object serialization instead of custom codec.
	private static final boolean USE_CUSTOM_CODEC = true;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NioSocketConnector connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(CONNECT_TIMEOUT);

		//		if (USE_CUSTOM_CODEC) {
		//			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new SumUpProtocolCodecFactory(false)));
		//		} else {
//		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		//		}

		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.setHandler(new IoHandlerAdapter(){
			/* (non-Javadoc)
			 * @see org.apache.mina.core.service.IoHandlerAdapter#messageReceived(org.apache.mina.core.session.IoSession, java.lang.Object)
			 */
			@Override
			public void messageReceived(IoSession session, Object message) throws Exception {
				System.out.println("messageReceived:" + message);
				super.messageReceived(session, message);
			}
			
			/* (non-Javadoc)
			 * @see org.apache.mina.core.service.IoHandlerAdapter#messageSent(org.apache.mina.core.session.IoSession, java.lang.Object)
			 */
			@Override
			public void messageSent(IoSession session, Object message) throws Exception {
				System.out.println("messageSent:" + message);
				super.messageSent(session, message);
			}
			
			/* (non-Javadoc)
			 * @see org.apache.mina.core.service.IoHandlerAdapter#sessionCreated(org.apache.mina.core.session.IoSession)
			 */
			@Override
			public void sessionCreated(IoSession session) throws Exception {
				System.out.println("sessionCreated:" + session.getId());
				super.sessionCreated(session);
			}
		});
		IoSession session;

		for (;;) {
			try {
				ConnectFuture future = connector.connect(new InetSocketAddress(HOSTNAME, PORT));
				future.awaitUninterruptibly();
				session = future.getSession();
				break;
			} catch (RuntimeIoException e) {
				System.err.println("Failed to connect.");
				e.printStackTrace();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		WriteFuture writeFuture = session.write("abc");
		writeFuture.awaitUninterruptibly();
		
		// wait until the summation is done
		session.getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}
}
