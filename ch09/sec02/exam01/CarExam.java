package ch09.sec02.exam01;

public class CarExam {
    public static void main(String[] args) {
        Car car = new Car();

        car.run1();

        car.run2();

        car.run3(new Tire() {
            @Override
            public void roll() {
                System.out.println("익명자식 3번이 굴러감");
            }
        });
    }
}