package ch08.sec09.CarExam;

public class Car {
    Tire tire1 = new Hankook();
    Tire tire2 = new Hankook();

    void run(){
        tire1.roll();
        tire2.roll();
    }
}
