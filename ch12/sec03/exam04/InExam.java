package ch12.sec03.exam04;

import java.io.IOException;

public class InExam {
    public static void main(String[] args) throws Exception {
        int speed = 0;
        int keyCode=0;

        while (true) {
            if (keyCode != 13 && keyCode != 10) {
                if (keyCode == 49) { // '1'
                    speed++;
                } else if (keyCode == 50) { // '2'
                    speed--;
                } else if (keyCode == 51) { // '3'
                    break; // 중지
                }

                System.out.println("----------------");
                System.out.println("1 증속 / 2 감속 / 3 중지");
                System.out.println("----------------");
                System.out.println("현재 속도 = " + speed);
                System.out.print("선택: ");
            }
            keyCode=System.in.read();
        }
        System.out.println("프로그램 종료");
    }
}