package ch08.sec09.CarExam;

public class CarExam {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.run();

        myCar.tire1 = new Kumho();
        myCar.tire2 = new Hankook();

        myCar.run();
    }
}
