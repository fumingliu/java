package com.delayQueue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DelayTest {
	public static void main(String[] args) {
		ItemQueueThread ith = ItemQueueThread.getInstance();
		ith.init();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			int a = r.nextInt(6);
			System.out.println("预先知道等待时间：" + a);
			DataDemo dd = new DataDemo(a);// 创建一个任务对象
			ith.put(a, dd, TimeUnit.SECONDS);// 将任务添加到队列中
		}
	}
}
// 注意ItemQueueThread的init方法，要在容器初始化的时候就要执行，或在第一次put延迟对象任务之前就要初始化完成，当设定的延迟时间到期时会执行任务对象中的run
