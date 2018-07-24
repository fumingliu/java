package com.proxy.impl;

import com.proxy.IUserDao;

public class ProxyFactoryTest {

	public static void main(String[] args) {
		// 目标对象
		IUserDao iUserDao = new UserDao();
		//原始类型
		System.out.println(iUserDao.getClass());
		
		//给目标对象创建代理对象
		IUserDao proxy = (IUserDao)new ProxyFactory(iUserDao).getProxyInstance();
		//代理对象
		System.out.println(proxy.getClass());
		proxy.save();
	}

}
