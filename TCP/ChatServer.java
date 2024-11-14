package TCP;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());

    // 서버 시작 메소드
    public void start() throws IOException {
        serverSocket = new ServerSocket(50001);
        System.out.println("( ´ ∀ ` )서버 스타트( ｡･ω･｡ )");

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("클라이언트가 연결 됐어요(♥‿♥) : " + socket.getInetAddress());
                }
            } catch (IOException e) {
            }
        });
        thread.start();
    }

    public void addSocketClient(SocketClient socketClient){
        String key = socketClient.chatName + "0" + socketClient.clientIp;
        chatRoom.put(key,socketClient);
        System.out.println("어서와요(っ´▽)っ : " + key);
        System.out.println("현재 채팅자 수(☞ﾟヮﾟ)☞ : " + chatRoom.size()+"\n");
    }


    public void removeSocketClient(SocketClient socketClient){
        String key = socketClient.chatName + "0" + SocketClient.clientIp;
        chatRoom.remove(key);
        System.out.println("잘가요(っ´▽)っ : " + key);
        System.out.println("현재 채팅자 수(☞ﾟヮﾟ)☞ : " + chatRoom.size()+"\n");
    }


    //json 메세지 생성 후 채팅방 클라이언트에게 메세지 보냄
    public void sendToAll(SocketClient sender,String message){
        JSONObject root=new JSONObject();
        root.put("clientIp",sender.clientIp);
        root.put("chatName",sender.chatName);
        root.put("message",message);
        String json = root.toString();

        Collection<SocketClient>socketClients=chatRoom.values();
        for(SocketClient sc:socketClients){
         if(sc==sender)continue;
         sc.send(json);
            }
        }

        public void stop(){
        try{
            serverSocket.close();
            threadPool.shutdownNow();
            chatRoom.values().stream().forEach(sc->sc.close());
            System.out.println("서버종료 (⊙_☉)");
        }catch (IOException e1){}
        }

        public static void main(String[]args){
        try {
            ChatServer chatServer =new ChatServer();
                            chatServer.start();

            System.out.println("--------------------------------");
            System.out.println("서버를 종료 하려면 q 입력 후 enter! ");
            System.out.println("--------------------------------");

            Scanner scanner =new Scanner(System.in);
            while (true){
                String key = scanner.nextLine();
                if(key.equals("q")) break;
            }

            scanner.close();
            chatServer.stop();
        } catch (IOException e) {
            System.out.println("[서버]"+e.getMessage());
        }
    }
}

