package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : ChatServer
 */
public class ChatServer {

    public static final int PORT = 12345;
    public static ServerSocket serverSocket;
    /*
    * 입장 : /join | {name} : 처음 채팅 서버에 접속할 때 사용자의 이름을 입력해야한다.
    * 메세지 : /message | {내용} : 모든 사용자에게 메세지를 전달한다.
    * 이름변경 : /change | {name} : 사용자의 이름을 변경한다.
    * 전체 사용자 : /users : 채팅 서버에 접속한 사용자 목록을 출력한다.
    * 종료 : /exit : 채팅 서버의 접속을 종료한다
    * */
    public static void main(String[] args) {
        log(" ======= 서버 시작 ======= ");
        ChatSessionManager manager = new ChatSessionManager();

        /* 서버 소켓 오픈 */
        try {
            serverSocket = new ServerSocket(PORT);
            log("서버 소켓 시작 - 리스닝 포트 : " + PORT);

            // ShutdownHook 등록
            ShutdownHook hook = new ShutdownHook(serverSocket, manager);
            Runtime.getRuntime().addShutdownHook(new Thread(hook, "Shutdown"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* 사용자 세션 생성 후 Thread 생성 -> thread.start() 까지 진행 */
        try{
            while (true) {
                Socket socket = serverSocket.accept();
                ChatSession chatSession = new ChatSession(socket, manager);
                Thread thread = new Thread(chatSession);
                thread.start();
            }
        } catch (IOException e){
            log("서버 소캣 종료 : " + e);
        }
    }

    static class ShutdownHook implements Runnable{
        private final ServerSocket serverSocket;
        private final ChatSessionManager manager;

        public ShutdownHook(ServerSocket serverSocket, ChatSessionManager manager) {
            this.serverSocket = serverSocket;
            this.manager = manager;
        }

        @Override
        public void run() {
            try {
                manager.closeAll();
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("[ERROR] : " + e);
            }

        }
    }
}
