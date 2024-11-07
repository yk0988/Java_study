public class p40 {
    public static void main(String[] args) {
        // 변수 교환을 위한 코드 예제 //

        // x와 y에 값을 각각 3과 5로 초기화
        int x = 3;
        int y = 5;

        // 초기 x와 y 값 출력
        System.out.println("x :" + x + "/  y :" + y);

        // 변수 temp를 사용하여 x와 y의 값을 교환
        int temp = x;  // x 값을 temp에 저장
        x = y;          // y의 값을 x에 할당
        y = temp;       // temp에 저장된 x 값을 y에 할당

        // 교환 후 x와 y 값 출력
        System.out.println("x :" + x + ",  y :" + y);
    }
}

