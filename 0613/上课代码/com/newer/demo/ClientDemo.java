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
			//��ȡ������������˷���Ϣ
			//192.168.1.104
			System.out.println("�����룺");
			String msg=br.readLine();
			out.println(msg);
			//��ȡ����˵�������
			String line=fromServer.readLine();
			System.out.println("�����˵:"+line);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
