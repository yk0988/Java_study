package ch04.sec05;

import java.util.Scanner;

public class dowhile {
    public static void main(String[] args) {
        System.out.println("메세지를 입력하세요");
        System.out.println("프로그램을 종료하려면 q를 누르세요");

        Scanner scanner =new Scanner(System.in);
        String inputString;

        do{
            System.out.println(">");
            inputString =scanner.nextLine();
            System.out.println(inputString);

        }while (! inputString.equals("q"));

        System.out.println();
        System.out.println("프로그램 종료");
        
    }
}

//한글 안됨 알아보기//