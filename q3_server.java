package com.soc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class q3_server
{
 
    private static Socket socket;
 
    public static void main(String[] args)
    {
        try
        {
 
        	int port = 7770;
            @SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(port);
            System.out.println("Server Started and listening to the port "+ port);
 
            //Server is running always. This is done using this while(true) loop
            while(true)
            {
                //Reading the message from the client
                socket = ss.accept();
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String msg = br.readLine();
                System.out.println("Message received from client is "+msg);
 
                //Encoding
                String returnMessage = "";
                for(int i=0; i<msg.length(); i++)
                {
                	char ch = msg.charAt(i);
                	ch= (char) (((ch - 'a' + 1) % 26) + 'a');
                	returnMessage = returnMessage + ch;
                }
                
                returnMessage = returnMessage + "\n";
              
 
                //Sending the response back to the client.
                OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Message sent to the client is "+returnMessage);
                bw.flush();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
            	 e.printStackTrace();
            }
        }
    }
}