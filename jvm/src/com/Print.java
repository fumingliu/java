package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;


public class Print {

	public static void main(String[] args) {
		//Print.ticket();

		String t = " +86,321(+6+8+8686)（）+86、/?.,0d3,217,";
		t = t.replaceAll("\\+86", "");
		System.out.println(t);
		List<Print.Man> list = new ArrayList<Print.Man>();
		list.add((new Print().new Man("zhangsan","1")));
		list.add((new Print().new Man("zhangsan","1")));
		list.add((new Print().new Man("lisi","2")));
		list.add((new Print().new Man("lisi","2")));
		list.add((new Print().new Man("zhangsan","3")));
		list.add((new Print().new Man("zhangsan","4")));
		Set<Print.Man> set = new TreeSet<Print.Man>(new Comparator<Print.Man>() {

			@Override
			public int compare(Man o1, Man o2) {
				
				return o1.getAge().concat(o1.getName()).compareTo(o2.getAge().concat(o2.getName()));
			}
			
		});
		set.addAll(list);
		list.clear();
		list.addAll(set);
		for (Print.Man m : list){
			System.out.println(m);
		}
		
		while(true){
			System.err.println(new Random().nextInt(1000) == 888 ? "shooting" : "");
		}
	}
	
	class Man {

		String name ;
		String age;
		public Man(String name ,String age){
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Man [name=" + name + ", age=" + age + "]";
		}
		
	}
	
	protected static  void ticket(){
		int totalNumber = 44;
		float price = 5;
		float totalPrice = 0;
		float discount = 1;
		for(int i = 1 ; i <= totalNumber ; i ++){
			if(totalPrice < 150){
				discount = 1f;
			}else if (totalPrice < 180 && totalPrice >=150){
				discount = 0.8f;
			}else{
				discount = 0.5f;
			}
			totalPrice += price * discount;
		}
		System.out.println(totalPrice);
	}

}
