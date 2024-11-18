package TCP;

/*
2024 11 18
오류 :챗 클라이언트에서 서로 메세지 전달 안됨
짝꿍 구본찬씨의 도움으로 성공함! 고마워용!
 */

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    ServerSocket serverSocket;  // 서버 소켓
    ExecutorService threadPool = Executors.newFixedThreadPool(100);  // 클라이언트 처리를 위한 스레드 풀
    Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());  // 접속한 클라이언트 관리 (대화명 + IP를 키로 사용)

    // 서버 시작 메소드
    public void start() throws IOException {
        serverSocket = new ServerSocket(50001);  // 포트 50001로 서버 시작
        System.out.println("( ´ ∀ ` )서버 스타트( ｡･ω･｡ )");

        // 클라이언트 연결을 기다리는 쓰레드
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    // 클라이언트 연결 수락
                    Socket socket = serverSocket.accept();
                    System.out.println("클라이언트가 연결 됐어요(♥‿♥) : " + socket.getInetAddress());
                    // 연결된 클라이언트 객체 생성
                    new SocketClient(this, socket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();  // 클라이언트 연결을 기다리는 쓰레드 시작
    }

    // 새로운 클라이언트를 채팅방에 추가하는 메소드
    //!!! addSocketClient : 이 부분에서 실행 안됐음. !!!!!
    public void addSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + SocketClient.clientIp;  // 대화명과 IP로 클라이언트 식별
        chatRoom.put(key, socketClient);  // 클라이언트를 chatRoom에 추가
        System.out.println("어서와요(っ´▽)っ : " + key);  // 클라이언트 접속 메시지 출력
        System.out.println("현재 채팅자 수(☞ﾟヮﾟ)☞ : " + chatRoom.size() + "\n");  // 현재 접속자 수 출력
    }

    // 클라이언트를 채팅방에서 제거하는 메소드
    public void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + SocketClient.clientIp;  // 클라이언트 식별
        chatRoom.remove(key);  // 클라이언트를 chatRoom에서 제거
        System.out.println("잘가요(っ´▽)っ : " + key);  // 클라이언트 퇴장 메시지 출력
        System.out.println("현재 채팅자 수(☞ﾟヮﾟ)☞ : " + chatRoom.size() + "\n");  // 현재 접속자 수 출력
    }

    // 모든 클라이언트에게 메시지를 보내는 메소드
    public void sendToAll(SocketClient sender, String message) {
        JSONObject root = new JSONObject();
        root.put("clientIp", sender.clientIp);  // 송신자의 IP
        root.put("chatName", sender.chatName);  // 송신자의 대화명
        root.put("message", message);  // 메시지 내용
        String json = root.toString();  // JSON 형식으로 메시지 변환

        // 채팅방에 있는 모든 클라이언트에게 메시지 전송
        Collection<SocketClient> socketClients = chatRoom.values();
        for (SocketClient sc : socketClients) {
            if (sc == sender) continue;  // 자신에게는 전송하지 않음
            sc.send(json);  // 메시지 전송
        }
    }

    // 서버를 종료하는 메소드
    public void stop() {
        try {
            serverSocket.close();  // 서버 소켓 닫기
            threadPool.shutdownNow();  // 스레드 풀 종료
            // 모든 클라이언트의 연결 종료
            chatRoom.values().forEach(sc -> sc.close());
            System.out.println("서버종료 (⊙_☉)");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    // 서버 실행 메소드
    public static void main(String[] args) {
        try {
            ChatServer chatServer = new ChatServer();
            chatServer.start();  // 서버 시작

            // 서버 종료 명령 입력 받기
            System.out.println("--------------------------------");
            System.out.println("서버를 종료 하려면 q 입력 후 enter! ");
            System.out.println("--------------------------------");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String key = scanner.nextLine();
                if (key.equals("q")) break;  // 'q' 입력 시 서버 종료
            }

            scanner.close();
            chatServer.stop();  // 서버 종료
        } catch (IOException e) {
            System.out.println("[서버]" + e.getMessage());
        }
    }
}
