package ch18.sec06;


import java.io.*;

public class CharatorCovert {
    public static void main(String[] args) throws Exception {
        write("문자변환!"); // 예시로 문자열을 작성합니다.
        String content = read();
        System.out.println(content); // 읽은 내용을 출력합니다.
    }

    public static void write(String str) throws Exception {
        OutputStream os = new FileOutputStream("c:/temp/tset.txt");
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        writer.write(str);
        writer.flush();
        writer.close();
    }

    public static String read() throws Exception {
        InputStream is = new FileInputStream("c:/temp/tset.txt");
        Reader reader = new InputStreamReader(is, "UTF-8");
        char[] data = new char[100];
        int num = reader.read(data);
        reader.close();
        return new String(data, 0, num);
    }
}
