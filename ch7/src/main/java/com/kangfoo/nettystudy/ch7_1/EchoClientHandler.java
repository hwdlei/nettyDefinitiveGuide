package com.kangfoo.nettystudy.ch7_1;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

/**
 * User: kangfoo-mac
 * Date: 14-7-20
 * Time: 下午6:13
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

	private int counter;

	private final int sendNumber;

	public EchoClientHandler(int sendNumber) {
		this.sendNumber = sendNumber;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		List<UserInfo> users = UserInfo();
		for (UserInfo user : users) {
			ctx.write(user);
		}
		ctx.flush();
	}

	private List<UserInfo> UserInfo() {
		List<UserInfo> users = new ArrayList<UserInfo>();
		for (int i = 0; i < sendNumber; i++) {
			users.add(new UserInfo().setAge(i).setName("ABCDEFG --->" + i));
		}
		return users;

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("CLient receive the msgpack message : " + msg);
		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
