package ch04.exam;

import java.util.Scanner;
// 양수, 음수, 0인지 구분하는 프로그램
public class Exam2 {
    public static void main(String[] args) {
        // 변수 선언
        int input;

        // 사용자에게 숫자 입력을 요청하는 메시지 출력
        System.out.print("숫자 입력: ");

        // Scanner 객체를 사용하여 사용자로부터 입력 받기
        Scanner scanner = new Scanner(System.in);

        // 사용자가 입력한 숫자를 input 변수에 저장
        input = scanner.nextInt();  // nextInt()는 사용자로부터 정수를 입력받음

        // 입력된 숫자가 양수인 경우
        if (input > 0) {
            System.out.println("양수입니다.");
        }
        // 입력된 숫자가 음수인 경우
        else if (input < 0) {
            System.out.println("음수입니다.");
        }
        // 입력된 숫자가 0인 경우
        else {
            System.out.println("0입니다.");
        }

        // Scanner 객체 닫기 (리소스 해제)
        scanner.close();
    }
}
