package com.newer.demo;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.getName().endsWith(".txt");
	}
	
	

}
