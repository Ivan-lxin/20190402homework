package com.newer.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try (
				ServerSocket ss=new ServerSocket(9977);
				Socket s=ss.accept();
				BufferedReader fromClient=new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter out=new PrintWriter(s.getOutputStream(),true);
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in))
				){
			
				System.out.println("����������");
				
				while(true) {
					String client=fromClient.readLine();
					if("88".equals(client)) {
						break;
					}
					System.out.println("�ͻ���˵:"+client);
					System.out.print("������:");
					String line=br.readLine();
					out.println(line);
				}
				System.out.println("ͨ�Ž���");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
