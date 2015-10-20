package com.kangfoo.nettystudy.ch7_1;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * User: kangfoo-mac
 * Date: 14-7-20
 * Time: 下午6:00
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

	int counter = 0;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Server receive the msgpack message : " + msg);
		ctx.writeAndFlush(msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
