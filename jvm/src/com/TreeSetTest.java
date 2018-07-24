package com;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {

		TreeSet ts = new TreeSet();
		ts.add(new TreeSetTest().new Person("zhangsan",12));
		ts.add(new TreeSetTest().new Person("zhangsan",12));
		ts.add(new TreeSetTest().new Person("wangwu",34));
		ts.add(new TreeSetTest().new Person("zhaoliu",22));
		Iterator i = ts.descendingIterator();
		Person p = null;
		while(i.hasNext()){
			p = (Person)i.next();
			System.out.println(p.toString());
		}
	}
	
	class Person implements Comparable<Person>{
		private String name ;
		private int age;
		public Person(String name , int age){
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public int compareTo(Person o) {
			int num = this.age - o.age;
			return num == 0 ? this.name.compareTo(o.name) : num;
//			return -1;
		}
		
		@Override
		public String toString(){
			return "name : " + name + ", age : " + age;
		}
		
//		@Override
//		public boolean equals(Object o){
//			
//			return true;
//		}
	}

}
