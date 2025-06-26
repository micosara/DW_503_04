package com.bookmarket.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapper {

	// Singletone pattern
	private static HandlerMapper instance = new HandlerMapper();
	private HandlerMapper() {}
	public static HandlerMapper getInstance() {
		return instance;
	}

	private Map<String, Controller> controllers = new HashMap<String, Controller>();

	{
		controllers.put("1", new UserInfoController());
		controllers.put("2", new CartListController());
		controllers.put("3", new CartRemoveAllController());
		controllers.put("4", new CartAddItemController());
		controllers.put("5", new CartCountUpdateController());
		controllers.put("6", new CartRemoveItemController());
		controllers.put("7", new CartBillController());
		controllers.put("8", new ExitController());
	}

	public Controller getController(String menu) {
		return controllers.get(menu);
	}
}











