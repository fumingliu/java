package com;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Map<String, Integer> map = new TreeMap<String, Integer>(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {return o2.compareTo(o1);};
//		});
		TreeMap<String, Integer> map = new TreeMap<String, Integer>(Collections.reverseOrder());
		map.put("2", 22);
		map.put("3", 23);
		map.put("1", 21);
		map.put("5", 25);
		map.put("7", 27);
		map.put("4", 24);
		String key = null;
		Integer value = null;
		Map.Entry<String, Integer> entry = null;
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			key = (String)iterator.next();
			value = map.get(key);
			System.out.println("键：" + key + ",值：" + value);
		}
		
		Iterator<Integer> iterator2 = map.values().iterator();
		while(iterator2.hasNext()){
			value = iterator2.next();
			System.out.println(value);
		}
		
		Iterator<Map.Entry<String, Integer>> iterator3 = map.entrySet().iterator();
		while(iterator3.hasNext()){
			entry = iterator3.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		iterator3 = map.descendingMap().entrySet().iterator();
		while(iterator3.hasNext()){
			entry = iterator3.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		Map m = new HashMap();
		m.put(1, 1);
		m.put(8, 8);
		m.put(4, 4);
		m.put(3, 3);
		m.put(5, 5);
		m.put(9, 9);
		m.put(7, 7);
		m.put(2, 2);
		map.clear();
		map.putAll(m);
		System.out.println(map.size());
		Iterator i = map.entrySet().iterator();
		Map.Entry e = null;
		while(i.hasNext()){
			e = (Map.Entry)i.next();
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		
		
	}

}
