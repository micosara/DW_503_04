package com.java.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map_EX01 {

	public static void main(String[] args) {
		
		Map<String, Object> dataMap = new HashMap<String,Object>();
		
//		dataMap.put(1,1);
		dataMap.put("1", false);
		dataMap.put("2", 12);
		dataMap.put("3", "a");
		dataMap.put("4", 1.2f);
		
		System.out.println(dataMap);
		System.out.println(dataMap.get("1"));
		
		System.out.println("value by key -------------------------------");
		Set<String> keys = dataMap.keySet();
		if(keys!=null) for(String obj : keys) {
			System.out.println(dataMap.get(obj));
		}
		
		System.out.println("values()  -------------------------------");
		Collection values = dataMap.values();
		if(values!=null) for(Object obj : values) {
			System.out.println(obj);
		}
		
		System.out.println("value by entrySet ------------------------");
		Set<Entry<String,Object>> entrySet = dataMap.entrySet();
		if(entrySet!=null) for(Entry<String,Object> entry:entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

	}
}






