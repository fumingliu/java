package com.proxy.impl;

public class CGlibProxyFactoryTest {

	public static void main(String args[]){
		UserDao userDao = new UserDao();
		System.out.println(userDao.getClass());
		UserDao proxy = (UserDao)new CGlibProxyFactory(userDao).getProxyInstance();
		System.out.println(proxy.getClass());
		proxy.save();
	}
}
