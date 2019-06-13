package com.newer.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {
	
	public static void main(String[] args) throws IOException {
		
		
		byte[] temp=new byte[1024];
		//定义用于接收数据的数据报对象
		DatagramPacket dp=new DatagramPacket(temp, temp.length);
		
		DatagramSocket ds=new DatagramSocket(8899);
		//接收数据报
		ds.receive(dp);
		//获取数据
		byte[] data=dp.getData();
		System.out.println(new String(data));
		
		ds.close();
	}

}
