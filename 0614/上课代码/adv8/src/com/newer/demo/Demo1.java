package com.newer.demo;

import java.io.File;
import java.io.IOException;

public class Demo1 {
	
	public static void main(String[] args) {
		
		
		FileUtil fu=new FileUtil();
		
		File file=new File("HomeWork");
		
		//fu.findFile(file);
		try {
			fu.changeName(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
