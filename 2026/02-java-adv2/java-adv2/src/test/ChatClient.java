package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : ChatClient
 */
public class ChatClient {
    public static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("채팅 클라이언트 시작");
        try (Socket socket = new Socket("localhost", PORT);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());) {
            System.out.println("소켓 연결 : " + socket);
            String received = input.readUTF();
            System.out.println(received);

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("나 : ");
                String toSend = sc.nextLine();
                output.writeUTF(toSend);
                received = input.readUTF();
                System.out.println(received);
            }

        } catch (UnknownHostException e) {
            System.out.println("[ERROR] : " + e);
        } catch (IOException e) {
            System.out.println("[ERROR] : " + e);
        }
    }
}
