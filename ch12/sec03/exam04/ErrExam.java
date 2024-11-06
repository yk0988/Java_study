package ch12.sec03.exam04;

public class ErrExam {
    public static void main(String[] args) {
        try {
            int value = Integer.parseInt("???");
        } catch (NumberFormatException e){
            System.err.println("에러 내용");
            System.err.println(e.getMessage());
        }
    }
}
