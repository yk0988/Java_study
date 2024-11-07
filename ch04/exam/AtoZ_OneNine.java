package ch04.exam;

import java.util.Scanner;

// 0~9 또는 A~Z만 출력하는 프로그램
public class AtoZ_OneNine {
    public static void main(String[] args) {
        // 사용자로부터 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 하나의 문자 입력을 요청하는 메시지 출력
        System.out.println("하나의 문자만 입력");

        // 사용자로부터 입력받은 문자열을 input 변수에 저장
        String input = scanner.nextLine();  // nextLine()은 사용자로부터 한 줄을 입력받음

        // 입력 값의 첫 번째 문자를 추출 (첫 번째 문자만 검사)
        char inData = input.charAt(0);  // 문자열에서 첫 번째 문자를 가져옴

        // 입력된 값이 유효한 숫자(0~9) 또는 대문자(A~Z)인지 확인하는 조건문
        if ((inData >= '0' && inData <= '9') || (inData >= 'A' && inData <= 'Z')) {
            // 조건에 맞으면 유효한 숫자 또는 문자임을 출력
            System.out.println("유효한 숫자 또는 문자입니다.");
        } else {
            // 조건에 맞지 않으면 유효하지 않은 데이터임을 출력
            System.out.println("유효하지 않은 데이터입니다.");
        }

        // Scanner 객체 닫기 (리소스 해제)
        scanner.close();
    }
}

