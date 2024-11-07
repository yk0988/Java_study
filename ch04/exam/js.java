package ch04.exam;

public class js {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 학생의 점수를 저장하는 변수
		int js = 80;

		// 학점으로 저장할 변수 (초기값은 공백)
		char grade = ' ';

		// 점수에 대한 결과를 10으로 나눈 몫으로 계산 (점수대 구하기)
		int result = js / 10; // 80 / 10 = 8 -> 80점은 8번째 구간에 해당

		// 점수대에 따라 학점 결정 (switch 문 사용)
		switch(result) {
			case 9:  // 점수가 90 이상이면 'A'
				grade = 'A';
				break;
			case 8:  // 점수가 80 이상 90 미만이면 'B'
				grade = 'B';
				break;
			case 7:  // 점수가 70 이상 80 미만이면 'C'
				grade = 'C';  // 대소문자에 주의해야 함. 'c'가 아니라 'C'가 맞을 것
				break;
			case 6:  // 점수가 60 이상 70 미만이면 'D'
				grade = 'D';
				break;
			default:  // 그 외의 점수는 'F'
				grade = 'F';
		}

		// 계산된 학점 출력
		System.out.println("당신의 학점은: " + grade);
	}
}
