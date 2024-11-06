package ch14.sec03.exam02;

import java.awt.Toolkit;

public class Beep {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체 생성
                for (int i = 0; i < 5; i++) {
                    toolkit.beep(); // 비프 소리 내기
                    try {
                        Thread.sleep(500); // 0.5초 대기
                    } catch (Exception e) {
                    }
                }
            }
        });

        thread.start(); // 스레드 시작

        for (int i = 0; i < 5; i++) {
            System.out.println("띵"); // "띵" 출력
            try {
                Thread.sleep(500); // 0.5초 대기
            } catch (Exception e) {
                e.printStackTrace(); // 예외 발생 시 출력
            }
        }
    }
}
