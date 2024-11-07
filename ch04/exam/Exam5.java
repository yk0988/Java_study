package ch04.exam;

import java.util.Scanner;

public class Exam5 {
    // 팩토리얼을 구하는 재귀 함수
    public static int factorial(int n) {
        // 기저 조건: 0! 또는 1!은 1로 정의됨
        if (n == 0 || n == 1) {
            return 1;  // 0!과 1!의 값은 1
        } else {
            // 재귀 호출: n! = n * (n-1)!
            return n * factorial(n - 1);  // n!은 n * (n-1)!으로 계산
        }
    }

    public static void main(String[] args) {
        // 사용자로부터 입력 받기
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 팩토리얼을 구할 숫자 입력을 요청하는 메시지 출력
        System.out.print("팩토리얼을 구할 숫자를 입력하세요: ");

        // 사용자가 입력한 숫자를 num 변수에 저장
        int num = scanner.nextInt();

        // 입력받은 숫자에 대한 팩토리얼 계산
        int result = factorial(num);

        // 계산된 팩토리얼 결과 출력
        System.out.println(num + "의 팩토리얼은: " + result);

        // Scanner 객체 닫기 (리소스 해제)
        scanner.close();
    }
}
