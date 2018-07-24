package com.singleton;

public class Singleton {

	/*持有私有静态实例，防止被引用，此处赋值为null，目的是为了延迟加载*/
	private static Singleton instance = null;
	
	/*私有构造方法，防止被实例化*/
	private Singleton(){
		
	}
	
	/*静态工程方法，创建实例*/
//	public static synchronized Singleton getInstance(){
//		if(instance == null) {
//			instance = new Singleton();
//		}
//		return instance;
//	}
	
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(instance){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	/*如果该对象被序列化，可以保证序列化前后保持一致*/
	public Object readResolve(){
		return instance;
	}
}