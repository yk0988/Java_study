package ch11.sec02.exam02;

public class Exception {

    public static void printLength(String date) {
        try {
           System.out.println("java.lang.string 클래스가 존재합ㄴㅣ다.");
            int result = date.length();
            System.out.println("문자 수" + result);

        } catch (NullPointerException e) {
            System.out.println("문자를 입력해주세요");

        } finally {
            System.out.println("[마무리 실행]\n");
        }
    }
    public static void main(String[] args){
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsBanana");
        printLength(null);
        printLength("[프로그램 종료]");

    }
}
