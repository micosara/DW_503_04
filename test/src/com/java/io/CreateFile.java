package com.java.io;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {
		String savedPath = "c:\\file\\my";
		File path = new File(savedPath);
		
		path.mkdirs();
		
		File fileObj = new File(savedPath,"Example01.txt");

		try {
			boolean success = fileObj.createNewFile();
			if (success) {
				System.out.println("颇老 积己 己傍");
			} else {
				System.out.println("颇老 积己 角菩");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
