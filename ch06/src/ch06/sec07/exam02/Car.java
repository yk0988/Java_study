package ch06.sec07.exam02;
//자체 필드//
public class Car {
    String model;
    String color;
    int maxspeed;



    //생성자//   //생성자에게 집어넣기 위한 인자들//
    Car (String model,String color,int maxspeed){
        this.model = model;  //디스는 충돌방지로 달아줌//
        this.color = color;
        this.maxspeed = maxspeed;

    }

}
