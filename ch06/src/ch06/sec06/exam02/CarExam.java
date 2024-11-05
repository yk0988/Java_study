package ch06.sec06.exam02;


//메인을 만들겄다//
public class CarExam {
    public static void main(String[] args) {
        //임포트 안뜰때 알트엔터//
        Car myCar = new Car();

        System.out.println("제조회사명 : "+ myCar.company);
        System.out.println("모델명 :"+ myCar.model);
        System.out.println("색상 : "+ myCar.color);
        System.out.println("최고속도 :"+ myCar.maxspeed);
        System.out.println("현재속도 :"+ myCar.speed);

        System.out.println();

        myCar.speed = 60;
        System.out.println("수정한 속도 :"+ myCar.speed);
    }

}
