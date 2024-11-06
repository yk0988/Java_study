package ch11.sec02.exam01;

public class Exception {
    public static void printLength(String date) {
        int result = date.length();
        System.out.println("문자 수" + result);
    }
    public static void main(String[] args){
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsBanana");
        printLength(null);
        printLength("[프로그램 종료]");

    }
}
