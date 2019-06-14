package com.newer.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	public void findFile(File file) {
		//ʹ���ļ�������
		//FileFilter ff=new FileFilterImpl();
		//�����ڲ���
//		File[] files=file.listFiles(new FileFilter() {
//			
//			@Override
//			public boolean accept(File pathname) {
//				// TODO Auto-generated method stub
//				return pathname.getName().startsWith("test");
//			}
//		});
//		
		//lamda���ʽʵ�ֺ���ʽ�ӿ�ΨһҪʵ�ֵķ���		
		File[] files=file.listFiles();
	
		
		for(File f:files) {
			System.out.println(f.getName());
			if(f.isDirectory()) {
				findFile(f);
			}
		}
	}
	
	public void changeName(File file) throws IOException {
		//��������.txt���ļ� 
		File[] files=file.listFiles(f1->f1.getName().endsWith(".txt"));
		//����Ҫ��ȡ�ļ������ļ�
		File namelist=new File("HomeWork/musicList.txt");
		//��ȡָ���ļ�
		BufferedReader br=new BufferedReader(new FileReader(namelist));
		String filename;
		while((filename=br.readLine())!=null) {
			for(File ff:files) {
				//�ж�Ҫ���������ļ����ַ���
				//��ȡ���ļ��������ַ�һ��				
				if(ff.getName().substring(0,1).equals(filename.substring(0,1))) {
					File newFile=new File(ff.getParent(), filename);
					//�������ļ�
					//����ͬ·������������ֻ���ļ��ĸ���
					//��ͬ·���£����ļ��ļ��к�������
					ff.renameTo(newFile);
					System.out.println(filename+"����������");
				}
			}
		}
		br.close();
	}
	

}
