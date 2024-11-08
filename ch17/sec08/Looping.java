package ch17.sec08;
import java.util.Arrays;

public class Looping {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5};

        // 짝수만 필터링하고 총합 계산
        int total = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .peek(n -> System.out.println(n)) // 짝수 출력
                .sum(); // 총합 계산

        System.out.println("총합: " + total + "\n");


        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .forEach(n-> System.out.println(n));
    }
}
