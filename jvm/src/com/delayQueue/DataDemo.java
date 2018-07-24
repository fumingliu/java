package com.delayQueue;

public class DataDemo implements Runnable {
	int a = -1;

	public DataDemo(int i) {
		this.a = i;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "超时，要撤销订单...." + a);
	}
}