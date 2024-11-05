package ch09.sec02.exam01;

public class Car {
    private Tire tire1 = new Tire();

    private Tire tire2 = new Tire() {
        @Override
        public void roll() {
            System.out.println("익명자식 1번이 굴러감");
        }
    };

    public void run1() {
        tire1.roll();
        tire2.roll();
    } // 여기서 run1 메서드의 중괄호를 닫습니다.

    public void run2() {
        Tire tire = new Tire() {
            @Override
            public void roll() {
                System.out.println("익명자식 2번이 굴러감");
            }
        };
        tire.roll();
    } // run2 메서드의 중괄호를 닫습니다.

    public void run3(Tire tire) {
        tire.roll();
    } // run3 메서드의 중괄호를 닫습니다.
}
