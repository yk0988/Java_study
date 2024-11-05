package ch06.sec07.exam02;

public class CarExam {
    public static void main(String[] args) {

        Car mycar = new Car("그랜저","겅정",350);


        System.out.println("모델명 : "+mycar.model);
        System.out.println("차 칼라 : "+mycar.color);
        System.out.println("최고속도 : "+mycar.maxspeed);
    }
}
