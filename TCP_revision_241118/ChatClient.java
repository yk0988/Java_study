package TCP;


/*
2024 11 18
오류 :챗 클라이언트에서 서로 메세지 전달 안됨
짝꿍 구본찬씨의 도움으로 성공함! 고마워용!
 */

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    Socket socket;  // 서버와의 소켓 연결
    DataInputStream dis;  // 서버로부터 데이터 읽기 위한 입력 스트림
    DataOutputStream dos;  // 서버로 데이터 전송을 위한 출력 스트림
    String chatName;  // 클라이언트의 대화명

    // 기본 생성자
    public ChatClient() {
    }

    // 서버에 연결하는 메소드
    public void connect() throws IOException {
        this.socket = new Socket("localhost", 50001);  // 서버 주소 및 포트로 연결
        this.dis = new DataInputStream(this.socket.getInputStream());  // 입력 스트림 초기화
        this.dos = new DataOutputStream(this.socket.getOutputStream());  // 출력 스트림 초기화
        System.out.println("[클라이언트] 서버에 연결됨");
    }

    // 서버로부터 메시지를 받는 메소드 (비동기적으로 실행)
    public void receive() {
        Thread thread = new Thread(() -> {
            try {
                while(true) {
                    // 서버로부터 메시지를 받음
                    String json = this.dis.readUTF();
                    JSONObject root = new JSONObject(json);  // JSON 객체로 변환
                    String clientIp = root.getString("clientIp");
                    String chatName = root.getString("chatName");
                    String message = root.getString("message");
                    // 받은 메시지 출력
                    System.out.println("<" + chatName + "@" + clientIp + "> " + message);
                }
            } catch (Exception var6) {
                System.out.println("[클라이언트] 서버 연결 끊김");
                System.exit(0);  // 연결 끊기면 종료
            }
        });
        thread.start();  // 별도의 스레드로 메시지 받기 시작
    }

    // 서버로 메시지를 보내는 메소드
    public void send(String json) throws IOException {
        this.dos.writeUTF(json);  // JSON 문자열 전송
        this.dos.flush();  // 출력 스트림 비우기
    }

    // 서버와 연결을 종료하는 메소드
    public void unconnect() throws IOException {
        this.socket.close();  // 소켓 닫기
    }

    // 클라이언트 실행 메소드
    public static void main(String[] args) {
        try {
            // 클라이언트 객체 생성 및 서버 연결
            ChatClient chatClient = new ChatClient();
            chatClient.connect();
            Scanner scanner = new Scanner(System.in);

            // 사용자로부터 대화명 입력 받기
            System.out.println("대화명 입력: ");
            chatClient.chatName = scanner.nextLine();

            // 클라이언트 대화명 서버에 전송 (입장 알림)
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("command", "incoming");
            jsonObject.put("data", chatClient.chatName);
            String json = jsonObject.toString();
            chatClient.send(json);

            // 서버로부터 메시지 받기 시작
            chatClient.receive();

            // 메시지 전송 및 종료 안내 출력
            System.out.println("--------------------------------------------------");
            System.out.println("보낼 메시지를 입력하고 Enter");
            System.out.println("채팅을 종료하려면 q 를 입력하고 Enter");
            System.out.println("--------------------------------------------------");

            // 메시지 입력 및 전송
            while(true) {
                String message = scanner.nextLine();
                if (message.toLowerCase().equals("q")) {  // 'q' 입력 시 종료
                    scanner.close();
                    chatClient.unconnect();
                    break;
                }

                // 메시지를 서버에 전송
                jsonObject = new JSONObject();
                jsonObject.put("command", "message");
                jsonObject.put("data", message);  // 실제 메시지 내용
                json = jsonObject.toString();
                chatClient.send(json);
            }
        } catch (IOException var6) {
            System.out.println("[클라이언트] 서버 연결 안됨");
        }
    }
}
