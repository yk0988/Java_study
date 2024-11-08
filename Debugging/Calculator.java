package Debugging;

public class Calculator {

    // 더하기
    public double add(double a, double b) {
        return a + b;
    }

    // 빼기
    public double sub(double a, double b) {
        return a - b;
    }

    // 곱하기
    public double mul(double a, double b) {
        return a * b;
    }

    // 나누기
    public double div(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }

    // 메인 메서드: 테스트용
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("더하기: " + calc.add(5, 3));    // 8.0
        System.out.println("빼기: " + calc.sub(5, 3));       // 2.0
        System.out.println("곱하기: " + calc.mul(5, 3));     // 15.0
        System.out.println("나누기: " + calc.div(5, 3));     // 1.666...
    }
}



