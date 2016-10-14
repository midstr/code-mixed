package org.minatest;

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
import org.apache.mina.handler.chain.ChainedIoHandler;
import org.apache.mina.handler.chain.IoHandlerChain;
import org.apache.mina.handler.chain.IoHandlerCommand;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author yaogangli
 * @date 2014-5-13 下午4:17:11
 */
public class MinaServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IoAcceptor acceptor = new NioSocketAcceptor();

		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		IoHandlerChain chain = new IoHandlerChain();
		chain.addFirst("1", new Command1());
		chain.addLast("2", new Command2());
		ChainedIoHandler handler = new ChainedIoHandler(chain);
		acceptor.setHandler(handler);
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		try {
			acceptor.bind(new InetSocketAddress(8081));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("server started....");
	}

}
