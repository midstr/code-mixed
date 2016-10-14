package org.minatest;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.handler.chain.IoHandlerCommand;

/**
 * @author yaogangli
 * @date 2014-5-13 下午6:37:03
 */
public class Command1 implements IoHandlerCommand {

	/* (non-Javadoc)
	 * @see org.apache.mina.handler.chain.IoHandlerCommand#execute(org.apache.mina.handler.chain.IoHandlerCommand.NextCommand, org.apache.mina.core.session.IoSession, java.lang.Object)
	 */
	@Override
	public void execute(NextCommand next, IoSession session, Object message) throws Exception {
		System.out.println("command1...");
		next.execute(session, message);
	}

}
