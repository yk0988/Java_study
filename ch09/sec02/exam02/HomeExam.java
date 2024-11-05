package ch09.sec02.exam02;

public class HomeExam {
    public static void main(String[] ars) {
        //Home : 객체생성//
        Home home = new Home();
        
        //익명 구현 객체 대입 [필드]//
        home.use1();
        
        //익명 구현 객체 대입 [로컬변수]//
        home.use2();

        //익명 구현 객체 대입 [매개변수]//
        home.use3(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("난방 on");
            }

            @Override
            public void turnOff() {
                System.out.println("난방 off");
            }
          });
       }
    }