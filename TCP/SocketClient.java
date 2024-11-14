package TCP;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
    ChatServer chatServer;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    static String clientIp;
    String chatName;

    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();
            receive(); // receive 메서드 호출
        } catch (IOException e) {
            e.printStackTrace(); // 예외 처리
        }
    }

    private void receive() {
        chatServer.threadPool.execute(() -> {
            try {
                while (true) {
                    String receiveJson = dis.readUTF();
                    JSONObject jsonObject = new JSONObject(receiveJson);
                    String command = jsonObject.getString("command");

                    switch (command) {
                        case "incoming":
                            this.chatName = jsonObject.getString("data");
                            chatServer.sendToAll(this, "들어오셨습니다.");
                            break;
                        case "message":
                            String message = jsonObject.getString("data");
                            chatServer.sendToAll(this, message);
                            break;
                    }
                }
            } catch (IOException e) {
                chatServer.sendToAll(this, "나가셨습니다.");
                chatServer.removeSocketClient(this);
                e.printStackTrace();
            }

        });
        }

    public void close() {
        try {
            socket.close();
        } catch (Exception e) {}
    }

    public void send(String json) {
        try {
            dos.writeUTF(json);
            dos.flush();
        } catch (Exception e) {
        }
    }
}
