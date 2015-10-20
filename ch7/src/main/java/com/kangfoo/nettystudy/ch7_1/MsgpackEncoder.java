package com.kangfoo.nettystudy.ch7_1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import org.msgpack.MessagePack;

public class MsgpackEncoder extends MessageToByteEncoder<Object> {

	@Override
	protected void encode(ChannelHandlerContext arg0, Object arg1, ByteBuf arg2) throws Exception {
		MessagePack msgPack = new MessagePack();
		byte[] raw = msgPack.write(arg1);
		arg2.writeBytes(raw);
	}

}
