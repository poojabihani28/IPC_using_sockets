package com.soc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
 
public class q4_client
{
    public static void main(String[] args) throws IOException
    {
    	String ip = "localhost";
		int port = 6968;
		Socket socket = new Socket(ip,port);
        
        Scanner sc = new Scanner(System.in);
        
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
 
        while (true)
        {
        	System.out.println("Calculate?");
        	String o = sc.next();
        	if(o.equals("no"))
        	{
        		break;
        	}
        	
        	System.out.println("Enter number1:");
        	int num1 = sc.nextInt();
 
        	System.out.println("Enter number2:");
        	int num2 = sc.nextInt();
        	
        	System.out.println("Operation");
        	String operation = sc.next();
        	
        	
            // send the inputs to server
        	dos.writeUTF(o);
        	dos.writeInt(num1); 
        	dos.writeInt(num2);
            dos.writeUTF(operation);
 
            // wait till request is processed and sent back to client
            String ans = dis.readUTF();
            System.out.println("Answer=" + ans);
        }
        
        sc.close();
        socket.close();
    }
}