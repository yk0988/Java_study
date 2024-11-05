package ch06.sec06.exam01;


//메인을 만들겄다//
public class CarExam {
    public static void main(String[] args) {
        //임포트 안뜰때 알트엔터//
        Car myCar = new Car();

        System.out.println("모델명"+ myCar.model);
        System.out.println("시동여부"+ myCar.start);
        System.out.println("현재속도"+ myCar.speed);
    }

}
