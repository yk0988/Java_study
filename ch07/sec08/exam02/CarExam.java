package ch07.sec08.exam02;

public class CarExam {
    public static void main(String[] args) {

        Car myCar= new Car();

        myCar.tire= new Tire();
        myCar.run();

        myCar.tire= new Hankook();
        myCar.run();

        myCar.tire= new Kumho();
        myCar.run();



    }
}
