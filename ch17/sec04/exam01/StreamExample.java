package ch17.sec04.exam01;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>(); // 제네릭 타입 지정

        for (int i = 1; i <= 5; i++) {
            Product product = new Product(i, "상품" + i, "멋진회사", (int)(10000.0 * Math.random()));
            list.add(product);
        }

        Stream<Product> stream = list.stream();
        stream.forEach(p -> {
            System.out.println(p); // 중괄호 정리
        }); // 여기에 추가 중괄호 없음
    }
}
