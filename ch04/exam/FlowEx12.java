package ch04.exam;

import java.util.Scanner;

public class FlowEx12 {

    public static void main(String[] args) {
        // 사용자에게 주민등록번호 입력을 요청하는 메시지 출력
        System.out.println("민번 입력 (ex: 011231-1111222)");

        // Scanner 객체를 사용하여 사용자로부터 주민등록번호 입력 받기
        Scanner scanner = new Scanner(System.in);

        // 사용자가 입력한 주민등록번호를 regNo 변수에 저장
        String regNo = scanner.nextLine();  // 주민등록번호 입력 받음

        // 주민등록번호에서 성별을 나타내는 8번째 문자 추출 (0부터 시작하는 인덱스 7)
        char gender = regNo.charAt(7);  // 성별 확인 (7번째 문자)

        // 성별과 출생년도에 따라 출력
        switch (gender) {
            case '1': case '3':  // 남성 (1은 1900년대 출생 남자, 3은 2000년대 출생 남자)
                // 삼항 연산자를 사용하여 2000년 이전과 이후 출생자 구분
                System.out.println((gender == '1' ? "남 :  2000년 이전 출생자" : "남 :  2000년 이후 출생자"));
                break;  // switch문 종료

            case '2': case '4':  // 여성 (2는 1900년대 출생 여자, 4는 2000년대 출생 여자)
                // 삼항 연산자를 사용하여 2000년 이전과 이후 출생자 구분
                System.out.println((gender == '2' ? "여 :  2000년 이전 출생자" : "여 :  2000년 이후 출생자"));
                break;  // switch문 종료

            default:  // '1', '2', '3', '4' 외의 값이 입력되었을 경우
                System.out.println("등록되지 않음");  // 유효하지 않은 주민등록번호
        }

        // Scanner 객체 닫기 (리소스 해제)
        scanner.close();
    }
}
