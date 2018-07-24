package com.proxy.impl;

import com.proxy.IUserDao;

public class UserDaoProxy implements IUserDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("open transaction...");
		userDao.save();
		System.out.println("close transaction...");
	}
	
	private IUserDao userDao;
	
	public UserDaoProxy(IUserDao userDao){
		this.userDao = userDao;
	}

}
