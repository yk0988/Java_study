package TCP;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String chatName;


    public void connect() throws IOException {
        socket=new Socket("localhost",50001);
        dis=new DataInputStream(socket.getInputStream());
        dos=new DataOutputStream(socket.getOutputStream());
        System.out.println("클라이언트 서버 연결");
    }

    public void receive(){
        Thread thread =new Thread(()-> {
        try{
        while (true){
            String json=dis.readUTF();
            JSONObject root=new JSONObject(json);
            String clientIP = root.getString("clientIP");
            String chatName = root.getString("chatName");
            String message = root.getString("message");
            System.out.println("<"+chatName+"0"+clientIP+">" + message);
        }
        } catch (IOException e1) {
            System.out.println("클라이언트 서버 끊김");
            System.exit(0);
        }
        });

    thread.start();
    }

    public void send(String json) throws IOException {
        dos.writeUTF(json);
        dos.flush();
    }

    public void unconnect() throws IOException{
    socket.close();
    }

    public static void main(String[]args){
    try {
        ChatClient chatClient=new ChatClient();
        chatClient.connect();

        Scanner scanner=new Scanner(System.in);
        System.out.println("대화명 입력 : ");
        chatClient.chatName=scanner.nextLine();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("command","incoming");
        jsonObject.put("data",chatClient.chatName);
        String json= jsonObject.toString();
        chatClient.send(json);

        chatClient.receive();

        System.out.println("---------------------------------");
        System.out.println("--메세지 입력 후 엔터를 눌러용  ^_^--");
        System.out.println("- 채팅을 종료 하려면 q입력하고 엔터! -");
        System.out.println("---------------------------------");

        while (true){
            String message=scanner.nextLine();
            if(message.toLowerCase().equals("q")) {
                break;
            }else {
                jsonObject=new JSONObject();
                jsonObject.put("command","message");
                jsonObject.put("data","message");
                json=jsonObject.toString();
                chatClient.send(json);
            }
        }
    scanner.close();
        chatClient.unconnect();
    } catch (IOException e) {
        System.out.println("서버 연결 안되용 ㅠㅠ");
    }
    }
}
