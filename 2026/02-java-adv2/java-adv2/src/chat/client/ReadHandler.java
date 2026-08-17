package chat.client;

import java.io.DataInputStream;
import java.io.IOException;

import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : ReadHandler
 */
public class ReadHandler implements Runnable{

    /* 서버의 메세지를 반복해서 받고, 콘솔에 출력하는 단순한 기능 제공 클래스 */
    private final DataInputStream input;
    private final Client client;
    public boolean closed = false;

    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;
    }

    @Override
    public void run() {
            try{
                while (true) {
                    String received = input.readUTF();
                    System.out.println(received);
                }
            } catch (IOException e) {
                log(e);
            } finally {
                client.close();
            }
    }

    /* 클라이언트 종료시 ReadHandler 도 종료됨으로 중복 종료를 막기 위해 동기화 코드 추가 / closed 플래그를 사용 */
    public synchronized void close(){
        if (closed) {
            return;
        }

        // 종료 로직 필요시 작성
        closed = true;
        log("readHandler 종료");
    }
}
