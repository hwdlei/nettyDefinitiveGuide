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
		//		msgPack.register(UserInfo.class);
		// serialize
		byte[] raw = msgPack.write(src);
		List<String> dst1 = msgPack.read(raw, Templates.tList(Templates.TString));
		System.out.println(dst1);

		UserInfo user = new UserInfo();
		user.setAge(1).setName("12312");
		byte[] raw1 = msgPack.write(user);
		Object obj = msgPack.read(raw1);
		System.out.println(obj);
	}
}
