package ch05.sec06;

public class ArrayCreateByValueList {
    public static void main(String[] args) {
        int[] scores; // 배열 변수 선언
        scores = new int[]{83, 90, 87}; // 배열 초기화
        int sum1 = 0;

        // 배열 요소들의 합을 구하는 for문
        for (int i = 0; i < 3; i++) {
            sum1 += scores[i];
        }

        // 총합 출력
        System.out.println("총합 :" + sum1);

        // 사용자 메서드 호출: 새로운 배열을 인자로 넘김
        printItem(new int[]{83, 90, 87});
    }

    // 배열을 출력하는 메서드
    public static void printItem(int[] scores) {
        for (int i = 0; i < 3; i++) {
            // 잘못된 인덱스 참조: scores[1]이 아니라 scores[i]로 출력해야 함
            System.out.println("scores[" + 1 + "]:" + scores[i]);
        }
    }
}
//총합 :260
//scores[0]:83
//scores[1]:90
//scores[2]:87
