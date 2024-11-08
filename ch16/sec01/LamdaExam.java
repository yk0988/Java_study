package ch16.sec01;

public class LamdaExam {
    public static void main(String[] args) {
        action((x, y) -> {
            int result = x + y;
            System.out.println(result);
        });
    }

    public static void action(Calculable calculable) {
        calculable.calculation(5, 10); // 예시로 5와 10을 전달
    }
}

