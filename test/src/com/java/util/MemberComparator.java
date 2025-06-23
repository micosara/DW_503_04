package com.java.util;

import java.util.Comparator;

import com.java.collection.Member;

public class MemberComparator implements Comparator<Member>{

	@Override
	public int compare(Member m1, Member m2) {
		return m1.getId().compareTo(m2.getId());
//		return m2.getId().compareTo(m1.getId());
	}

	

}
