package datagramsocketclient;
import java.net.*;
public class DatagramSocketClient
{
    public static void main(String[] args)throws Exception {
        String line="ConnectedwithClient";
        DatagramSocket clientSocket=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");
        byte[] sendData=new byte[1024];
         byte[] receiveData=new byte[1024];
         sendData=line.getBytes();
         DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9000);
         clientSocket.send(sendPacket);
         System.out.println("****ClientDisplayTerminal****");
         
         while(true){
             DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
                clientSocket.receive(receivePacket);
                String messageReceived=new String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
                System.out.println("Message typed at server side is:"+messageReceived);
         }

        
    }
}