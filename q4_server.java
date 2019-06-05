package com.soc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

 
public class q4_server
{
    public static void main(String args[]) throws IOException
    {
 
    	ServerSocket ss = new ServerSocket(6968);
    	System.out.println("Server is waiting for client request ");
    	Socket socket = ss.accept(); 
    	System.out.println("client connected");
    	
    	DataInputStream dis = new DataInputStream(socket.getInputStream());
    	DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
 
        while (true)
        {
        	String o = (dis.readUTF());
        	int num1 = (dis.readInt());
        	int num2 = (dis.readInt());
        	String operation = (dis.readUTF());
 
            System.out.println("Equation received: " + num1 + operation + num2);
            int result;
 
            if(o.equals("yes"))
            {
            	// perform the required operation.
                if (operation.equals("+"))
                {
                    result = num1 + num2;
                }
     
                else if (operation.equals("-"))
                {
                    result = num1 - num2;
                }
                else if (operation.equals("*"))
                {
                    result = num1 * num2;
                }
                else
                {
                    result = num1 / num2;
                }
                
                System.out.println("Sending the result...");
                // send the result back to the client.
                dos.writeUTF(Integer.toString(result));
            }
            else if(o.equals("no"))
            {
            	System.out.println("done");
            	socket.close();
            	ss.close();
            }
        }
    }
}