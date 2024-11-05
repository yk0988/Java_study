package ch06.sec15;

public class SingletonExam {
    public static void main(String[] args) {

        Singleton oj1 = Singleton.getInstance();
        Singleton oj2 = Singleton.getInstance();

        if(oj1 == oj2){
            System.out.println("같은 Singleton 객체");
        }else {
            System.out.println("다른 Singleton 객체");
            }
        }
    }