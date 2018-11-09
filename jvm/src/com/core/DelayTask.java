package com.core;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/**
 * 延时任务对象，用于存放延时任务，将该对象放入延时队列中
 * @author ming
 *
 * @param <T extends Runnable> imp Delayed
 */
public class DelayTask<T extends Runnable> implements Delayed{

	//到期时间
	private final long time;
	
	//延时任务
	private final T task;
	
	//原子类
	private static final AtomicLong atomicLong = new AtomicLong(0);
	
	//实例化次数
	private final long n;
	
	public DelayTask(long timeOut,T task,TimeUnit unit) {
		this.time = TimeUnit.NANOSECONDS.convert(timeOut, unit) + System.nanoTime();
		this.task = task;
		this.n = atomicLong.getAndIncrement();
	}
	
	@Override
	public int compareTo(Delayed o) {
		
		if(o == this){
			return 0;
		}
		
		if(o instanceof DelayTask){
			DelayTask<?> x = (DelayTask<?>)o;
			long diff = time - x.time;
			if (diff > 0) {
				return 1;
			}else if(diff < 0){
				return -1;
			}else if (n > x.n) {
				return 1;
			}else {
				return -1;
			}
		}
		
		long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
		return d == 0 ? 0 : (d < 0 ? -1 : 1);
	}

	//返回延时任务的剩余时间，以给定的时间单位显示
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
	}
	
	//获取延时任务
	public T getTask(){
		return this.task;
	}

	@Override
	public int hashCode(){
		return this.task.hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o instanceof DelayTask){
			return o.hashCode() == hashCode() ? true : false; 
		}
		
		return false;
	}
}
