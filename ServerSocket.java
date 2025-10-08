package server;
import java.net.*;
import java.io.*;
public class ServerSocket {
     public static void main(String[] args)throws Exception {
        java.net.ServerSocket servSocket=new java.net.ServerSocket(4000);
        System.out.println("***Server side***");
        System.out.println("server ready for connection ");
        Socket connSock=servSocket.accept();
        System.out.println("connection is successful and ready for file transfer");
        InputStream istream=connSock.getInputStream();
        BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
        String fname=fileRead.readLine();
        File fileName=new File(fname);
        OutputStream ostream=connSock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        if(fileName.exists()){
            BufferedReader contentRead=new BufferedReader(new FileReader(fname));
            System.out.println("writing file contents to the socket");
            String str;
            while((str=contentRead.readLine())!=null){
                pwrite.println(str);
            }
            contentRead.close();
            }
        else{
            System.out.println("requested file doesnot exist");
            String msg="requested file doesnot exist at server side";
            pwrite.println(msg);
        }
        connSock.close();
        servSocket.close();
        fileRead.close();
        pwrite.close();
        }
    
}
