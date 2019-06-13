package com.newer.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 双方向点对点单次通信
 */
public class ServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//try-resource方式		
		try(
			//定义服务端
			ServerSocket ss=new ServerSocket(8889);
			//获取与某个客户端连接的socket
			Socket s=ss.accept();
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//获取socket输出流用于向连接的客户端输出数据
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);
			BufferedReader br1=new BufferedReader(new InputStreamReader(System.in))		){
			
			System.out.println("服务启动成功");
						
			System.out.println(s.getInetAddress()+":连接上了");
			//接收客户端输入流
			String msg=br.readLine();
			System.out.println("客户端说:"+msg);
			System.out.println("请输入：");
			String line=br1.readLine();
			//用输出流向客户端发消息
			out.println(line);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
