package com.newer.demo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			InetAddress address=InetAddress.getByName("www.baidu.com");
			
			System.out.println(address);
			//��ָ����������һ�����󣬷�����Ӧ����
			URL url=new URL("http://www.newer2001.com/");
			
			System.out.println(url.getProtocol());
			
			URLConnection conn=url.openConnection();
			//��ȡ��Ӧͷ������
			System.out.println(conn.getHeaderFields());
			//��ȡ��Ӧ��������
			InputStream is=url.openStream();
			FileOutputStream fos=new FileOutputStream(new File("newer.html"));
			
			byte[] temp=new byte[1024];
			
			while(is.read(temp)!=-1) {
				fos.write(temp, 0, temp.length);
			}
			
			is.close();
			fos.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
