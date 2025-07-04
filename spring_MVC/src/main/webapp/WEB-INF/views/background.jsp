<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	body{
		background:<% out.print(request.getAttribute("color")); %>
		
	}
</style>