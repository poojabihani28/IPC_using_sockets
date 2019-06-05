package com.soc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class q2_server
{
 
    private static Socket socket;
 
    public static void main(String[] args)
    {
        try
        {
 
            int port = 7779;
            @SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(port);
            System.out.println("Server Started and listening to the port "+ port);
 
            //Server is running always. 
            while(true)
            {
                //Reading the message from the client
                socket = ss.accept();
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String number = br.readLine();
                System.out.println("Message received from client is "+number);
 
                //Add 100 and return
                String returnMessage;
                try
                {
                    int n = Integer.parseInt(number);
                    int returnValue = n + 100;
                    returnMessage = String.valueOf(returnValue) + "\n";
                }
                catch(NumberFormatException e)
                {
                    //Input not a number. 
                    returnMessage = "Please send a proper number\n";
                }
 
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