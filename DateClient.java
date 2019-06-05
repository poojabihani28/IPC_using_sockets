package com.soc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {

	public static void main(String[] args) throws Exception
	{
		String ip = "localhost";
		int port = 8889;
		Socket socket = new Socket(ip,port);
		
		InputStreamReader isr= new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		
		System.out.println("Server Date and Time: " + str);
		
		br.close();
		socket.close();
		
	}
}
