package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;

public class Readline {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new FileReader("src/ch18/sec07/exam02/Readline.java")
        );

        int linenNo = 1;
        while(true){
            String str = br.readLine();
            if(str == null)break;
            System.out.println(linenNo+"\t"+str);
            linenNo++;
        }
        br.close();
    }
}
