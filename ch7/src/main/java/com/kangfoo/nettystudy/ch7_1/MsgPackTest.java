package com.kangfoo.nettystudy.ch7_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

public class MsgPackTest {

	public static void main(String[] args) throws IOException {
		List<String> src = new ArrayList<>();
		src.add("abc");
		src.add("def");
		src.add("ghi");
		MessagePack msgPack = new MessagePack();
		// serialize
		byte[] raw = msgPack.write(src);
		List<String> dst1 = msgPack.read(raw, Templates.tList(Templates.TString));
		System.out.println(dst1);

	}

}
