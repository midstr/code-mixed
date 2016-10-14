package org.midstr.mina.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author yaogangli
 * @date 2013-6-17 下午2:28:00
 */
public class MinaTimeServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		IoAcceptor acceptor = new NioSocketAcceptor();

		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		acceptor.setHandler(new IoHandlerAdapter() {
			@Override
			public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
				cause.printStackTrace();
			}

			@Override
			public void messageReceived(IoSession session, Object message) throws Exception {
				System.out.println("messageReceived:" + message);
				String str = message.toString();
				if (str.trim().equalsIgnoreCase("quit")) {
					session.close();
					return;
				}

				Date date = new Date();
				session.write(date.toString());
				System.out.println("Message written...");
			}
			
			/* (non-Javadoc)
			 * @see org.apache.mina.core.service.IoHandlerAdapter#messageSent(org.apache.mina.core.session.IoSession, java.lang.Object)
			 */
			@Override
			public void messageSent(IoSession session, Object message) throws Exception {
				System.out.println("messageSent:" + message);
				super.messageSent(session, message);
			}

			@Override
			public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
				System.out.println("IDLE " + session.getIdleCount(status));
			}
		});

		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);

		acceptor.bind(new InetSocketAddress(12345));

	}

}
