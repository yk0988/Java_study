public class p50 {
    public static void main(String[] args) {
        // 논리타입 (boolean) 예제 //

        // stop 변수에 true 값을 할당
        boolean stop = true;

        // stop이 true이면 아래의 코드 실행
        if(stop) {
            System.out.println();  // 빈 줄 출력 (실제로 출력되는 내용 없음)
        }

        // stop이 true일 경우 "중지합니다" 출력, 아니면 "시작합니다" 출력
        if(stop) {
            System.out.println("중지합니다");
        }
        else {
            System.out.println("시작합니다");
        }

        // x 값을 10으로 할당
        int x = 10;

        // 논리 비교 연산자 사용: x가 20과 같으면 result1에 true, 아니면 false 할당
        boolean result1 = (x == 20);

        // x가 20과 같지 않으면 result2에 true, 아니면 false 할당
        boolean result2 = (x != 20);

        // result1의 값을 출력 (x == 20의 결과)
        System.out.println("result 1 :" + result1);

        // result2의 값을 출력 (x != 20의 결과)
        System.out.println("result 2 :" + result2);
    }
}
