package com.newer.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	public void findFile(File file) {
		//使用文件过滤器
		//FileFilter ff=new FileFilterImpl();
		//匿名内部类
//		File[] files=file.listFiles(new FileFilter() {
//			
//			@Override
//			public boolean accept(File pathname) {
//				// TODO Auto-generated method stub
//				return pathname.getName().startsWith("test");
//			}
//		});
//		
		//lamda表达式实现函数式接口唯一要实现的方法		
		File[] files=file.listFiles();
	
		
		for(File f:files) {
			System.out.println(f.getName());
			if(f.isDirectory()) {
				findFile(f);
			}
		}
	}
	
	public void changeName(File file) throws IOException {
		//返回所有.txt的文件 
		File[] files=file.listFiles(f1->f1.getName().endsWith(".txt"));
		//定义要读取文件名的文件
		File namelist=new File("HomeWork/musicList.txt");
		//读取指定文件
		BufferedReader br=new BufferedReader(new FileReader(namelist));
		String filename;
		while((filename=br.readLine())!=null) {
			for(File ff:files) {
				//判断要重命名的文件首字符与
				//读取的文件名的首字符一致				
				if(ff.getName().substring(0,1).equals(filename.substring(0,1))) {
					File newFile=new File(ff.getParent(), filename);
					//重命名文件
					//在相同路径下重命名，只是文件的改名
					//不同路径下，是文件的剪切和重命名
					ff.renameTo(newFile);
					System.out.println(filename+"重命名结束");
				}
			}
		}
		br.close();
	}
	

}
