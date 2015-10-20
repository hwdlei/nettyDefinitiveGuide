package com.kangfoo.nettystudy.ch7_1;

import org.msgpack.annotation.Message;

@Message
public class UserInfo {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public UserInfo setName(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public UserInfo setAge(int age) {
		this.age = age;
		return this;
	}

	@Override
	public String toString() {
		return "name : " + name + ", age : " + age;
	}
}
