package com.example.udp_jason;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import android.util.Log;

public class BroadCastUdp extends Thread
{
	private String dataString;
	private DatagramSocket udpSocket;
	private byte[] buffer=null;
	private  final int DEFAULT_PORT = 6666;
	
	public BroadCastUdp(String dataString)
	{
		this.dataString = dataString;
	}

	public void run()
	{
		Log.v("thread", "thread start");
		DatagramPacket dataPacket = null;
		try
		{
			buffer = dataString.getBytes();
			udpSocket = new DatagramSocket();
			udpSocket.setBroadcast(true);
			
			dataPacket = new DatagramPacket(buffer, buffer.length,InetAddress.getByName("255.255.255.255"),DEFAULT_PORT);			
			udpSocket.send(dataPacket);
			
			DatagramPacket dpIn = null;
			byte[] bufferIn = new byte[1024];
			dpIn = new DatagramPacket(bufferIn,bufferIn.length);
			udpSocket.receive(dpIn);
			
			String result = new String(bufferIn,0,buffer.length);
			System.out.println(result);	
			Log.i("result","result "+result);
			
			String strMsg=new String(dpIn.getData()).trim();
            Log.i("UDP Demo", "result "+dpIn.getAddress().getHostAddress().toString()+ ":" +strMsg );
			
		} catch (Exception e) 	{
			e.printStackTrace();
		} finally {		
			if(udpSocket!= null) {
				udpSocket.close();
			}
		}
	}
	
}
