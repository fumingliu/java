package com.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	private Lock lock = new ReentrantLock();
	public static void main(String[] args) {

		final LockTest lockTest = new LockTest();
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					lockTest.method(Thread.currentThread());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					lockTest.method(Thread.currentThread());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
	
	private void method(Thread thread) throws InterruptedException{
//		lock.lock();
//		try{
//			System.out.println("线程" + thread.getName() + "获取了锁");
//			Thread.sleep(1000);
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			System.out.println("线程" + thread.getName() + "释放了锁");
//			lock.unlock();
//		}
		
		if(lock.tryLock(1,TimeUnit.SECONDS)){
			try{
				System.out.println("线程" + thread.getName() + "获取了锁");
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
				System.out.println("线程" + thread.getName() + "释放了锁");
			}
		}else{
			System.out.println("我是线程" + thread.getName() + ",锁已经有人获取我就不要了！");
		}
	}
	

}
