package com.newer.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/*
 * ˫�����Ե���ͨ��
 */
public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try (
				Socket s=new Socket("localhost", 9977);
				PrintWriter out=new PrintWriter(s.getOutputStream(),true);
				BufferedReader fromServer=new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in))
				){
			
				while(true) {
					System.out.print("������:");
					String msg=br.readLine();
					out.println(msg);
					if("88".equals(msg)) {
						break;
					}
					String line=fromServer.readLine();
					System.out.println("�����:"+line);
				}
				System.out.println("ͨ�Ž���");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
