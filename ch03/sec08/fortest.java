package sec08;

public class fortest {
    public static void main(String[] args) {
        // for문을 이용하여 0부터 99까지 5씩 증가하는 반복문

        // i는 0부터 시작해서 100 미만까지 5씩 증가
        for (int i = 0; i < 100; i += 5) {

            // i가 0보다 클 때만 출력 (i가 0일 경우는 출력되지 않음)
            if (i > 0) {
                System.out.println(i); // i 값을 출력
            }
        }
    }
}
