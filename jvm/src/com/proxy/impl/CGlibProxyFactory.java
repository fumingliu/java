package com.proxy.impl;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxyFactory implements MethodInterceptor{

	private Object target;
	public CGlibProxyFactory(Object target){
		this.target = target;
	}
	
	public Object getProxyInstance(){
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		return en.create();
	}
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("open tansaction 3 ...");
		Object returnValue = arg1.invoke(target, arg2);
		System.out.println("close tansaction 3 ...");
		return returnValue;
	}

}
