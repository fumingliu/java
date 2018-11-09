package com.concurrent;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Counter {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Json");
		System.out.println(JSONObject.toJSONString(map));
	}

}
