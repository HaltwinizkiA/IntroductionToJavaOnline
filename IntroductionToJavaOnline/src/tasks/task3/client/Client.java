package tasks.task3.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private static BufferedReader br;
    private static DataOutputStream oos;
    private static DataInputStream ois;
    private static Socket clientSocket;
    public void start() {

        try {
            clientSocket = new Socket("localhost", 4004);
            br = new BufferedReader(new InputStreamReader(System.in));
            oos = new DataOutputStream(clientSocket.getOutputStream());
            ois = new DataInputStream(clientSocket.getInputStream());
            clientSocket.setSoTimeout(100);

            while (true) {
                String a="";
                while (true) {
                    try {
                        a = ois.readUTF();
                        Thread.sleep(50);
                        System.out.println(a);
                    } catch (Exception e) {
                        break;
                    }

                }

                if (a.equals("Goodbye")) {
                    break;
                }
                oos.writeUTF(br.readLine());

            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                ois.close();
                oos.close();
                clientSocket.close();
                System.out.println("Client closed");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}