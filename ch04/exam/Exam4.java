package ch04.exam;

import java.util.Scanner;  // Scanner 클래스를 사용하기 위한 import 구문 추가

public class Exam4 {

    public static void main(String[] args) {
        // 변수 선언
        int score = 0;   // 점수를 저장할 변수 score 초기화
        char grade = ' '; // 학점을 저장할 변수 grade 초기화 (기본값은 공백)

        // 사용자로부터 점수를 입력받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        System.out.print("점수를 입력하세요: ");  // 사용자에게 점수 입력 요청

        // 사용자로부터 입력받은 점수를 score에 저장
        score = scanner.nextInt();  // 정수 형태로 입력받아 score에 저장

        // 학점 계산 (조건문을 사용하여 점수에 맞는 학점 할당)
        if (score >= 90) {
            grade = 'A';  // 점수가 90 이상이면 학점은 'A'
        } else if (score >= 80) {
            grade = 'B';  // 점수가 80 이상 90 미만이면 학점은 'B'
        } else if (score >= 70) {
            grade = 'C';  // 점수가 70 이상 80 미만이면 학점은 'C'
        } else if (score >= 60) {
            grade = 'D';  // 점수가 60 이상 70 미만이면 학점은 'D'
        } else {
            grade = 'F';  // 점수가 60 미만이면 학점은 'F'
        }

        // 계산된 학점 출력
        System.out.println("당신의 학점은: " + grade);  // 학점 출력

        // Scanner 객체 닫기 (리소스 해제)
        scanner.close();
    }
}
