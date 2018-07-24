package com;

import java.util.ArrayList;
import java.util.List;

public class MonitoringTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		fillHeap(1000);
	}

	static class OOMObject{
		public byte[] placeholder = new byte[64 * 1024];
	}
	
	public static void fillHeap(int num) throws InterruptedException{
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0 ; i < num ; num ++){
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}
}
