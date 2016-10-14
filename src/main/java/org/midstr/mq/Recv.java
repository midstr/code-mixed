package org.midstr.mq;

import java.io.IOException;

/**
 * @author yaogangli
 * @date 2013-7-4 上午11:55:48
 */
public class Recv {

	private final static String QUEUE_NAME = "hello";

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws ConsumerCancelledException
	 * @throws ShutdownSignalException
	 */
	public static void main(String[] args) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub

//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("localhost");
//		Connection connection = factory.newConnection();
//		Channel channel = connection.createChannel();
//
//		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//
//		QueueingConsumer consumer = new QueueingConsumer(channel);
//		channel.basicConsume(QUEUE_NAME, true, consumer);
//		int index = 0;
//		while (true) {
//			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//			//String message = new String(delivery.getBody());
//			byte[] data = delivery.getBody();
//			System.out.println(" [x] Received '" + (++index)+ "'");
//		}
	}

}
