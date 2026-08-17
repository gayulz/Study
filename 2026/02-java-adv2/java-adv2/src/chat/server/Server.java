package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : Server
 */
public class Server {
    private final int PORT;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private ServerSocket serverSocket;


    public Server(int PORT, CommandManager commandManager, SessionManager sessionManager) {
        this.PORT = PORT;
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
    }

    public void start() throws IOException {
        log("서버 시작:" + commandManager.getClass());
        serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 , 리스닝 포트: " + PORT);

        addShutdownHook();
        running();
    }


    private void addShutdownHook() {
        ShutdownHook target = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(target, "shutdown"));
    }


    private void running() {
        try{
            while (true) {
                Socket socket = serverSocket.accept();
                log("소켓 연결: " + socket);
                Session session = new Session(socket, commandManager, sessionManager);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소켓 종료 : " + e);
        }

    }

    static class ShutdownHook implements Runnable {
        private final ServerSocket serverSocket;
        private final SessionManager sessionManager;

        public ShutdownHook(ServerSocket serverSocket, SessionManager sessionManager) {
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            log("shutdownHook 실행");
            try{
                sessionManager.closeAll();
                serverSocket.close();

                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();;
                System.out.println("e = " + e);
            }
        }
    }

}
