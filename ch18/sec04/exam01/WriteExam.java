package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExam {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("C:/Temp/test.txt");

            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            //배열출력
            char[] arr = { 'C', 'D', 'E' };
            writer.write(arr);

            writer.write("FGH");

            //문자 출력
            writer.flush();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
