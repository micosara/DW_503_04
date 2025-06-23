package com.java.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.java.util.MemberComparator;

public class TreeSet_EX01 {

	public static void main(String[] args) {
		
		Set treeSet = new TreeSet();
		Set hashSet = new HashSet();
		
		Object[] data = {"a","c","b","12","±è","a13","z","A","aA1","%"};
		
		for(int i = 0; i<data.length;i++) {
			treeSet.add(data[i]);
			hashSet.add(data[i]);
		}
		
		System.out.println("treeSet : "+treeSet);
		System.out.println("hashSet : "+hashSet);
		
		
//		Set<Member> memberSet = new TreeSet<Member>();
		Set<Member> memberSet = new TreeSet<Member>(new MemberComparator());
		for(int i = 0; i < 10; i++) {
			memberSet.add(new Member("mimi"+i,"mimi"+i, "mimi"+i ));
		}
//		System.out.println(memberSet);
		
		Iterator<Member> it = memberSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getId());
		}
		
		System.out.println("-----------------------------");
		
		
		if(memberSet!=null) for(Member mem : memberSet) {
			System.out.println(mem.getId());
		}
	}

}






