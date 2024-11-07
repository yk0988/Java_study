package ch04.exam;

import java.util.Scanner;

public class FlowEx11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 사용자에게 주민등록번호 입력을 요청하는 메시지 출력
		System.out.println("민번 입력 (ex:011231-1111222) ");

		// Scanner 객체를 사용하여 사용자로부터 주민등록번호 입력 받기
		Scanner scanner = new Scanner(System.in);

		// 입력받은 주민등록번호를 regNo 변수에 저장
		String regNo = scanner.nextLine();

		// 주민등록번호에서 성별을 나타내는 8번째 문자 추출
		char gender = regNo.charAt(7);

		// 성별 코드에 따라 분기처리
		switch (gender) {
			case '1': case '3':  // 1번, 3번은 남자
				switch (gender) {
					case '1':  // '1'은 1900년대 출생 남자
						System.out.println("남 :  2000 년 이전 출생자");
						break;
					case '3':  // '3'은 2000년대 출생 남자
						System.out.println("남 :  2000 년 이후 출생자");
						break;
				}
				break;  // 첫 번째 switch문에서 빠져나옴 (누락되지 않도록 주의)

			case '2': case '4':  // 2번, 4번은 여자
				switch (gender) {
					case '2':  // '2'는 1900년대 출생 여자
						System.out.println("여 :  2000 년 이전 출생자");
						break;
					case '4':  // '4'는 2000년대 출생 여자
						System.out.println("여 :  2000 년 이후 출생자");
						break;
				}
				break;  // 두 번째 switch문에서 빠져나옴 (누락되지 않도록 주의)

			default:  // 1, 2, 3, 4 외의 값이 입력되었을 경우
				System.out.println("등록되지 않음");  // 유효하지 않은 주민등록번호
		}

		// Scanner 객체 닫기 (리소스 해제)
		scanner.close();
	}  // main 끝
}
