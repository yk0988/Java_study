package ch04.exam;

public class ForEach {
	public static void main(String[] args) {
		// 1부터 3까지의 숫자를 배열로 저장
		int[] numbers = {1, 2, 3};

		// for-each문을 사용하여 배열의 각 요소를 출력
		// 'for (타입 변수명 : 배열)' 형식으로 배열을 순차적으로 반복
		for (int num : numbers) {
			System.out.println(num);  // 배열 numbers의 요소인 1, 2, 3을 차례대로 출력
		}

		// 출력 후 공백 라인 출력
		System.out.println("    ");

		// 문자열 배열을 선언하여 1부터 3까지의 문자열 저장
		String[] number = {"1", "2", "3"};

		// for-each문을 사용하여 문자열 배열의 각 요소를 출력
		// 'for (타입 변수명 : 배열)' 형식으로 배열을 순차적으로 반복
		for (String num : number) {
			System.out.println(num);  // 배열 number의 요소인 "1", "2", "3"을 차례대로 출력
		}
	}
}
