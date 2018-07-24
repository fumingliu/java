package com.proxy.impl;


public class UserDaoProxyTest {

	public static void main(String args[]) {
		UserDaoProxy userDaoProxy = new UserDaoProxy(new UserDao());
		userDaoProxy.save();
	}
}
