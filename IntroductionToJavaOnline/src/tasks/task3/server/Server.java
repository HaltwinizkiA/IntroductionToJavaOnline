package tasks.task3.server;

import tasks.task3.Builder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataOutputStream out;
    private static DataInputStream in;
public void start(){
    try {
        ServerSocket server= new ServerSocket(4004);
        System.out.println("Server is on");
        Socket socket=server.accept();
        System.out.println("User is connected");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        Builder builder=new Builder(in,out);
        builder.build();




    }catch (Exception e){
        System.out.println(e);
    }finally {
        try {
            in.close();
            out.close();

            System.out.println("Server closed");
        } catch (Exception e) {
            System.out.println(e);
        }

    }



}
}
