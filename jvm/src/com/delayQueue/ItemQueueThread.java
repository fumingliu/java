package com.delayQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

//延迟队列存放有效期对象
public class ItemQueueThread {
	private static final Logger logger = Logger
			.getLogger(ItemQueueThread.class);

	private ItemQueueThread() {

	}

	// 延迟加载（线程安全）
	private static class LazyHolder {
		private static ItemQueueThread itemQueueThread = new ItemQueueThread();
	}

	public static ItemQueueThread getInstance() {
		return LazyHolder.itemQueueThread;
	}

	// 缓存线程池
	ExecutorService executor = Executors.newCachedThreadPool();
	// 线程
	private Thread daemonThread;

	// 初始化线程
	public void init() {
		daemonThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					execute();
				} catch (InterruptedException e) {
					e.printStackTrace();
					logger.info(e.getMessage());
				}

			}
		});
		System.out.println("init......start");
		daemonThread.start();
	}

	private void execute() throws InterruptedException {
		while (true) {
//			Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
//			System.out.println("线程数...." + map.size());
//			System.out.println(System.currentTimeMillis());
//			System.out.println(item.size());
//			System.out.println("线程状态----" + Thread.currentThread().getState());
			try {
				// 从延迟队列中取值，如果没有对象过期责队列一直等待
				DelayItem<?> t1 = item.take();
				if (t1 != null) {
					Runnable task = t1.getTask();
					if (task == null) {
						continue;
					}
					executor.execute(task);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		}
	}

	// 创建空的延迟队列
	private DelayQueue<DelayItem<?>> item = new DelayQueue<>();

	// 往队列中添加任务
	public void put(long time, Runnable task, TimeUnit timeUnit) {
		// 转换成ns
		long nanoTime = TimeUnit.NANOSECONDS.convert(time, timeUnit);
		DelayItem<?> k = new DelayItem(nanoTime, task);
		item.put(k);
	}

	// 结束任务
	public boolean endTask(DelayItem<Runnable> task) {
		return item.remove(task);
	}
}

// 把需要延迟的功能代码单独抽取出来作为一个类，继承Runnable实现run方法
