package com.bookmarket.controller;

import java.util.Map;

public abstract class Controller {

	public abstract void execute(Map<String,Object> request)throws Exception;
}
