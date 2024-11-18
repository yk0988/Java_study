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
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
    ChatServer chatServer;  // 서버 객체
    Socket socket;  // 클라이언트와 연결된 소켓
    DataInputStream dis;  // 서버로부터 데이터 읽기 위한 입력 스트림
    DataOutputStream dos;  // 서버로 데이터 전송을 위한 출력 스트림
    static String clientIp;  // 클라이언트의 IP 주소
    String chatName;  // 클라이언트의 대화명

    // 클라이언트 객체 생성 시 호출되는 생성자
    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());  // 입력 스트림 초기화
            this.dos = new DataOutputStream(socket.getOutputStream());  // 출력 스트림 초기화
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();  // 클라이언트의 IP 주소
            receive();  // 클라이언트로부터 메시지를 받는 메소드 호출
        } catch (IOException e) {
            e.printStackTrace();  // 예외 발생 시 출력
        }
    }

    // 클라이언트로부터 메시지를 받는 메소드
    private void receive() {
        chatServer.threadPool.execute(() -> {
            try {
                while (true) {
                    // 서버로부터 받은 메시지 읽기
                    String receiveJson = dis.readUTF();
                    JSONObject jsonObject = new JSONObject(receiveJson);  // JSON 형식으로 변환
                    String command = jsonObject.getString("command");  // 명령어 추출

                    // 명령어에 따라 처리
                    switch (command) {
                        case "incoming":  // 클라이언트 입장
                            this.chatName = jsonObject.getString("data");  // 클라이언트 대화명 설정
                            chatServer.sendToAll(this, "들어오셨습니다.");  // 입장 메시지 전송
                            chatServer.addSocketClient(this);  // 클라이언트를 채팅방에 추가 < !!! 이 부분에서 실행 안됐음. !!!!!
                            break;
                        case "message":  // 클라이언트가 보낸 메시지
                            String message = jsonObject.getString("data");  // 메시지 내용
                            chatServer.sendToAll(this, message);  // 메시지 전송
                            break;
                    }
                }
            } catch (IOException e) {
                // 연결이 끊어졌을 때 처리
                chatServer.sendToAll(this, "나가셨습니다.");  // 퇴장 메시지 전송
                chatServer.removeSocketClient(this);  // 클라이언트를 채팅방에서 제거
            }
        });
    }

    // 클라이언트 소켓을 닫는 메소드
    public void close() {
        try {
            socket.close();  // 소켓 연결 종료
        } catch (Exception e) {
            e.printStackTrace();  // 예외 처리
        }
    }

    // 서버로 메시지를 보내는 메소드
    public void send(String json) {
        try {
            dos.writeUTF(json);  // JSON 형식으로 메시지 전송
            dos.flush();  // 출력 스트림 비우기
        } catch (Exception e) {
            e.printStackTrace();  // 예외 발생 시 처리
        }
    }
}
