package com.java.collection;

import java.util.HashSet;
import java.util.Set;

public class Member_main {

	public static void main(String[] args) {
		Member mem1 = new Member("mimi","mimi","mimi");
		Member mem2 = new Member("mimi","mama","mama");
		Member mem3 = new Member("mimi","mumu","mumu");

		
//		List<Member> memberList = new ArrayList<Member>();
		Set<Member> memberList = new HashSet<Member>();
		memberList.add(mem1);
		memberList.add(mem2);
		memberList.add(mem3);
		
		
		System.out.println(memberList.size());
		System.out.println(memberList);
		
		
		Member target = new Member("mama",null,null);
		//System.out.println(memberList.indexOf(target));
//		
//		memberList.remove(target);
//		
//		System.out.println(memberList.size());

	}

}




