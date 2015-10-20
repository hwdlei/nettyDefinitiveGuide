package com.kangfoo.nettystudy.ch2._2_3_NIO;

/**
 * User: kangfoo-mac
 * Date: 14-7-20
 * Time: 下午1:06
 */
public class TimeClient {

	public static void main(String[] args) {
		int port = 23000;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// TODO 请自行扩展.
			}
		}

		new Thread(new TimeClientHandle("192.168.6.129", port), "TimeClient-001").start();
	}
}
