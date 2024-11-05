package ch06.sec07.Exam05;

public class Car {

        String company="현대";
        String model;
        String color;
        int maxspeed;

        Car(String model){
            this(model,"은색",250);
        }

        Car(String model, String color){
            this(model,"은색",250);
        }
        Car(String model, String color, int maxspeed){
            this.model=model;
            this.color=color;
            this.maxspeed=maxspeed;
        }

    }
