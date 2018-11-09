package com.core;

import org.apache.log4j.Logger;

public class BookTicket implements Runnable {

	private Logger logger = Logger.getLogger(this.getClass());
	private int i = 1;
	@Override
	public void run() {
		logger.info("number : " + i++ + ", threadName : " + Thread.currentThread().getName());
	}

}
