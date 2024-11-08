package ch17.sec10;
// 1 평균 계산의 여러 가지 방법을 보여줌
// 2 리스트가 비어 있을 경우 처리하는 방법도 포함.
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
    // 기본 생성자
    public OptionalExample() {
    }

    public static void main(String[] args) {
        // 정수 리스트 생성
        List<Integer> list = new ArrayList<>();

        // 리스트의 평균을 OptionalDouble로 계산
        OptionalDouble optional = list.stream()
                .mapToInt(Integer::intValue)
                // 리스트의 Integer 값을 int로 변환
                .average(); // 평균 계산
        // 평균이 존재하는지 확인
        if (optional.isPresent()) {
            System.out.println("방법1_평균: " + optional.getAsDouble());
            // 평균 출력
        } else {
            System.out.println("방법1_평균: 0.0"); // 평균이 없을 경우 출력
        }

        // 다른 방법으로 평균 계산 및 기본값 설정
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                // 리스트의 Integer 값을 int로 변환
                .average() // 평균 계산
                .orElse(0.0); // 평균이 없으면 0.0 반환
        System.out.println("방법2_평균: " + avg); // 평균 출력

        // 또 다른 방법으로 평균 계산 및 출력
        list.stream().mapToInt(Integer::intValue)
                // 리스트의 Integer 값을 int로 변환
                .average() // 평균 계산
                .ifPresent((a) -> { // 평균이 존재할 경우
                    System.out.println("방법3_평균: " + a); // 평균 출력
                });
    }
}
