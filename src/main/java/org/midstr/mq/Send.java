package org.midstr.mq;

import java.io.IOException;

/**
 * @author yaogangli
 * @date 2013-7-4 上午11:55:41
 */
public class Send {

	private final static String QUEUE_NAME = "hello";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		//ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
//		byte[] data = new byte[1024*1024];
//		Random random = new Random();
//		random.nextBytes(data);
//		
//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("localhost");
//		Connection connection = factory.newConnection();
//		Channel channel = connection.createChannel();
//
//		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//		
//		long start = System.currentTimeMillis();
//		for (int  i = 0; i < 10000;i++) {
//			System.out.println("send " +(++i));
//			channel.basicPublish("", QUEUE_NAME, null, data);
//		}
//		System.out.println(System.currentTimeMillis() - start);
//		channel.close();
//		connection.close();
	}

//	public static class SendMsgTask implements Runnable {
//
//		private byte[] data;
//		private Channel channel;
//		private int index;
//
//		/**
//		 * 
//		 */
//		public SendMsgTask(byte[] data, Channel channel, int index) {
//			this.data = data;
//			this.channel = channel;
//			this.index = index;
//		}
//
//		/* (non-Javadoc)
//		 * @see java.lang.Runnable#run()
//		 */
//		@Override
//		public void run() {
//			try {
//				
//				System.out.println(index + " [x] Sent  message");
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

}
