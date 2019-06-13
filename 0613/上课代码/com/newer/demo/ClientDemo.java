package com.newer.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Socket s=new Socket("localhost", 8889);
			PrintWriter out=new PrintWriter(s.getOutputStream(), true);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				BufferedReader fromServer=new BufferedReader(new InputStreamReader(s.getInputStream()))) {
			//获取输出流，向服务端发消息
			//192.168.1.104
			System.out.println("请输入：");
			String msg=br.readLine();
			out.println(msg);
			//获取服务端的输入流
			String line=fromServer.readLine();
			System.out.println("服务端说:"+line);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
