package com.kangfoo.nettystudy.ch2._2_1_BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * User: kangfoo-mac
 * Date: 14-7-20
 * Time: 上午1:15
 */
public class TimeClient {

	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// TODO 请自行扩展.
			}
		}

		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		Scanner scanner = null;

		try {
			socket = new Socket("localhost", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			scanner = new Scanner(System.in);

			while (true) {
				String line = scanner.nextLine();
				if (line.equals("QUIT")) {
					break;
				}
				out.println(line);
				System.out.println("Send order 2 server succeed.");
				String resp = in.readLine();
				System.out.println("Now is : " + resp);
			}
		} catch (IOException e) {
			e.printStackTrace(); //To change body of catch statement use File | Settings | File Templates.
		} finally {
			if (scanner != null) {
				scanner.close();
				scanner.close();
			}
			if (out != null) {
				out.close();
				out = null;
			}

			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				socket = null;
			}
		}

	}

}
