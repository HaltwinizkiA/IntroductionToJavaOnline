package tasks.task3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader br;
    private static DataOutputStream oos;
    private static DataInputStream ois;

    public static void main(String[] args) {

        try {
            clientSocket = new Socket("localhost", 4004);
            br = new BufferedReader(new InputStreamReader(System.in));
            oos = new DataOutputStream(clientSocket.getOutputStream());
            ois = new DataInputStream(clientSocket.getInputStream());
            clientSocket.setSoTimeout(100);

            while (true) {
                String a = "";
                while (true) {
                    try {
                        a = ois.readUTF();
                        Thread.sleep(250);
                        System.out.println(a);
                    } catch (Exception e) {
                        break;
                    }
                }
                if (a.equals("disconnect")) {
                    break;
                }
                oos.writeUTF(br.readLine());


                //остановился на проблеме вывода вот изза этой темы с вайлом программа ждет ввода
                //с консоли нуб вторник не сделашье пойдешь нахуй

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