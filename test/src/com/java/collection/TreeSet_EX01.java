package com.java.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet_EX01 {

	public static void main(String[] args) {
		
		Set treeSet = new TreeSet();
		Set hashSet = new HashSet();
		
		Object[] data = {1,2,10,5,6,8,3,7,4};
		
		for(int i = 0; i<data.length;i++) {
			treeSet.add(data[i]);
			hashSet.add(data[i]);
		}
		
		System.out.println("treeSet : "+treeSet);
		System.out.println("hashSet : "+hashSet);
	}

}






