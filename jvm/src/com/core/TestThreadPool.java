package com.core;

import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestThreadPool {

	Logger logger = Logger.getLogger(this.getClass());
	
	//@Test
	public void testMaximum(){
		logger.info("start testing...");
		ExecutorService executor = Executors.newCachedThreadPool();
		ThreadPoolExecutor e = (ThreadPoolExecutor)executor;
		logger.info("getActiveCount:" + e.getActiveCount());
		logger.info("getCompletedTaskCount:" + e.getCompletedTaskCount());
		logger.info("getCorePoolSize:" + e.getCorePoolSize());
		logger.info("getKeepAliveTime:" + e.getKeepAliveTime(TimeUnit.SECONDS));
		logger.info("getLargestPoolSize:" + e.getLargestPoolSize());
		logger.info("getMaximumPoolSize:" + e.getMaximumPoolSize());
		logger.info("getPoolSize:" + e.getPoolSize());
		logger.info("getTaskCount:" + e.getTaskCount());
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		logger.info("getAllStackTraces:" + map.size());
	}
	
	@Test
	public void testDelayQueue() throws InterruptedException{
		DelayQueue<DelayTask<?>> queue = new DelayQueue<>();
		BookTicket bookTicket;
		DelayTask<Runnable> delayTask;
		int t = 1;
		while(true){
			bookTicket = new BookTicket();
			delayTask = new DelayTask<Runnable>(3, bookTicket,TimeUnit.SECONDS);
			queue.offer(delayTask);
			if(t++ >= 20){
				break;
			}
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		while(!queue.isEmpty()){
			DelayTask<?> d = queue.take();
			if(d != null && d.getTask() != null){
				executor.execute(d.getTask());
				BookTicket bookTicket1 = (BookTicket) d.getTask();
				DelayTask<Runnable> delayTask1 = new DelayTask<Runnable>(3, bookTicket1,TimeUnit.SECONDS);
				queue.offer(delayTask1);
			}
		}
	}
	
}
