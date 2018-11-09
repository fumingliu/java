package com.queue2stack;

import java.util.Queue;
/**
 * 由两个队列实现一个栈
 * @author ming
 *
 */

public class MyStack {

	//插入队列
	Queue<Object> q1;
	//中转队列
	Queue<Object> q2;
	
	/**
	 * 入栈
	 */
	public void offer(Object o){
		q1.offer(o);
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public Object poll(){
		
		if(q1.size() <= 1){
			return q1.poll();
		}else{
			int t = q1.size();
			for(int i = 0 ; i < t - 1 ; i ++){
				q2.offer(q1.poll());
			}
			Object m = q1.poll();
			t = q2.size();
			for(int j = 0 ; j < t ; j ++){
				q1.offer(q2.poll());
			}
			return m;
		}
	}
	
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.offer(1);
		myStack.offer(2);
		myStack.offer(3);
		myStack.offer(4);
		myStack.offer(5);
		System.out.println(myStack.poll());
	}
}
