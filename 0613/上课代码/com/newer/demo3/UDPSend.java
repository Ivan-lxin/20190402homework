package com.newer.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSend {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String str="hello world!";
		
		byte[] temp=str.getBytes();
		//����Ҫ���͵����ݱ���ָ����С�����շ���ַ�Ͷ˿�
		DatagramPacket dp=new DatagramPacket(temp, temp.length, InetAddress.getLocalHost(), 8899);

		DatagramSocket ds=new DatagramSocket();
		
		ds.send(dp);
		
		ds.close();
		
	}

}
