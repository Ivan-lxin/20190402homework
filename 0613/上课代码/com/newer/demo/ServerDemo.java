package com.newer.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * ˫�����Ե㵥��ͨ��
 */
public class ServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//try-resource��ʽ		
		try(
			//��������
			ServerSocket ss=new ServerSocket(8889);
			//��ȡ��ĳ���ͻ������ӵ�socket
			Socket s=ss.accept();
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//��ȡsocket��������������ӵĿͻ����������
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);
			BufferedReader br1=new BufferedReader(new InputStreamReader(System.in))		){
			
			System.out.println("���������ɹ�");
						
			System.out.println(s.getInetAddress()+":��������");
			//���տͻ���������
			String msg=br.readLine();
			System.out.println("�ͻ���˵:"+msg);
			System.out.println("�����룺");
			String line=br1.readLine();
			//���������ͻ��˷���Ϣ
			out.println(line);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
