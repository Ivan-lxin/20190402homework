package com.newer.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {
	
	public static void main(String[] args) throws IOException {
		
		
		byte[] temp=new byte[1024];
		//�������ڽ������ݵ����ݱ�����
		DatagramPacket dp=new DatagramPacket(temp, temp.length);
		
		DatagramSocket ds=new DatagramSocket(8899);
		//�������ݱ�
		ds.receive(dp);
		//��ȡ����
		byte[] data=dp.getData();
		System.out.println(new String(data));
		
		ds.close();
	}

}
