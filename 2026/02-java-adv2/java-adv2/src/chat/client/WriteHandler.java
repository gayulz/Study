package chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : WriteHandler
 */
public class WriteHandler implements Runnable{
    private static final String DELIMITER = "|";
    private final DataOutputStream output;
    private final Client client;
    private boolean closed;

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            String username = inputUsername(sc);
            output.writeUTF("/join" + DELIMITER + username);
            while (true) {
                String toSend = sc.nextLine();
                if(toSend.isEmpty()){
                    continue;
                }
                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                /* "/" 로 시작하면 명령어, 나머지는 일반 메세지 */
                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                } else {
                    output.writeUTF("/message" + DELIMITER + toSend);
                }
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private String inputUsername(Scanner sc) {
        System.out.print("사용자 이름을 입력하세요.: ");
        String username;

        do {
            username = sc.nextLine();
        } while (username.isEmpty());
        return username;

    }

    public synchronized void close(){
        if (closed) {
            return;
        }

        try{
            /* Scanner 입력 중지 , 사용자의 입력을 닫아버림 */
            System.in.close();
        } catch (IOException e) {
            log(e);
        }

        closed = true;
        log("writeHandler 종료");
    }
}
