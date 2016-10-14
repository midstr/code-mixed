package org.midstr.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class TestCHSGraphic {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 设置Headless模式

		// System.setProperty("java.awt.headless", "true");

		BufferedImage bi = new BufferedImage(200, 100,
				BufferedImage.TYPE_INT_RGB);

		Graphics g = bi.getGraphics();

		String s = "Headless模式测试";

		g.drawString(new String(s.getBytes(), "GB2312"), 50, 50);

		ImageIO.write(bi, "jpeg", new File("D:\\test.jpg"));

	}
}
