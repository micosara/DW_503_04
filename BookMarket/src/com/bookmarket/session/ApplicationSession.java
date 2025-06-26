package com.bookmarket.session;

import java.util.HashMap;
import java.util.Map;

public class ApplicationSession {

	private static ApplicationSession session = new ApplicationSession();
	private ApplicationSession() {}
	public static ApplicationSession getSession() {
		return session;
	}
	
	private Map<String,Object> attributes = new HashMap<String,Object>();
	
	public void setAttribute(String key, Object value) {
		attributes.put(key, value);
	}
	public Object getAttribute(String key) {
		return attributes.get(key);
	}
	
	public void removeAttribute(String key) {
		attributes.remove(key);
	}
}




