package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : Session
 */
public class ChatSession implements Runnable {
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final ChatSessionManager manager;

    private String name;
    private boolean closed = false;

    public ChatSession(Socket socket, ChatSessionManager manager) throws IOException {
        this.socket = socket;
        this.manager = manager;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.manager.add(this);
    }

    /*
     * 입장 : /join | {name} : 처음 채팅 서버에 접속할 때 사용자의 이름을 입력해야한다.
     * 메세지 : /message | {내용} : 모든 사용자에게 메세지를 전달한다.
     * 이름변경 : /change | {name} : 사용자의 이름을 변경한다.
     * 전체 사용자 : /users : 채팅 서버에 접속한 사용자 목록을 출력한다.
     * 종료 : /exit : 채팅 서버의 접속을 종료한다
     * */
    @Override
    public void run() {
        try {
            String toSend = "";
            output.writeUTF("채팅 서버에 연결 되었습니다. 명령어를 입력하세요.\n" +
                    "========================================================\n" +
                    "입장 : /join | {닉네임}\n" +
//                    "메세지 : /message | {내용}\n" +
//                    "이름변경 : /change | {name}\n" +
//                    "전체 사용자 조회 : /users\n" +
//                    "채팅 종료 : /exit\n" +
                    "========================================================");
            while (true) {
                toSend = "";
                String received = input.readUTF();
                System.out.println("received = " + received);
                String[] menu = getOrder(received);
                switch (menu[0]) {
                    case "/join":
                        setName(menu[1]);
                        toSend = name + "설정 완료 되었습니다";
                        break;
                    case "/message":
                        break;
                    case "/change":
                        break;
                    case "/users":
                        toSend = manager.selectUsers();
                        break;
                    case "/exit":
                        toSend = "채팅 서버에서 연결을 종료합니다.";
                        output.writeUTF(toSend);
                        manager.remove(this);
                        close();
                        break;
                    default:
                        toSend = "해당 명령어는 없습니다.";
                        break;
                }
                output.writeUTF(toSend);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            manager.remove(this);
            close();
        }
    }

    private static String[] getOrder(String received) {
        String[] order = new String[2];
        if(received.indexOf("/exit") > 0 || received.indexOf("/users") > 0){
            order[0] = received.split("\\|")[0].replaceAll(" ", "");
            return order;
        }

        if(received.indexOf("\\|") == -1){
            order[0] = "X";
            return order;
        }


        order[0] = received.split("\\|")[0].replaceAll(" ", "");
        order[1] = received.split("\\|")[1];
        return order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public synchronized void close() {
        if (closed) return;
        closeAll(socket, input, output);
        closed = true;
        log("연결 종료 :" + socket + " | " + socket.isClosed());
    }
}
