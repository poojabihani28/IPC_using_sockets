package com.soc;

import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateServer
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Server is started");
		ServerSocket ss = new ServerSocket(8889);
		
		System.out.println("Server is waiting for client request ");
		Socket socket = ss.accept();
		
		System.out.println("client connected");
		
		OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    
	    os.write(df.format(dateobj));	
		os.flush();
		
		socket.shutdownOutput();
		ss.close();
		
	}
}
