package ch12.sec03.exam04;

public class ExitExam {
    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            System.out.println(i);
            if(i==5){

                System.out.println("프로세스 강제종료");
                System.exit(0);
            }

        }
    } }