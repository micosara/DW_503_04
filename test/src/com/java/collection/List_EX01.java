package com.java.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class List_EX01 {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		//list.remove(2);
		//list.clear();
		
//		System.out.println(list.size());
//		System.out.println(list.get(2));
		
//		Iterator<Integer> it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		System.out.println(list.contains(1));

	}

}


