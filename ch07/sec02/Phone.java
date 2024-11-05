package ch07.sec02;

public class Phone {
    public static String model;  //
    public static String color;  //

    public void bell() {
        System.out.println("벨이 울립니다.");
    }

    public void sendVoice(String message) {
        System.out.println("상대방: " + message);  // 공백 추가
    }

    public void receiveVoice(String message) {
        System.out.println("상대방: " + message);  // 공백 추가
    }

    public void hangUp() {
        System.out.println("전화 끝");
    }
}
