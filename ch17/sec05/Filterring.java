package ch17.sec05;

import java.util.ArrayList;
import java.util.List;

public class Filterring {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // 제네릭 타입 지정

        // 요소 추가 시 list 객체를 사용
        list.add("홍길동");
        list.add("신용건");
        list.add("김자바");
        list.add("신용건");
        list.add("신민철");

        list.stream()
        .distinct()
        .forEach(n-> System.out.println(n));
        System.out.println();

        list.stream()
                .filter(n->n.startsWith("신"))
                .forEach(n-> System.out.println(n));
        System.out.println();

        // 리스트의 내용을 출력
        list.stream()
                .distinct()
                .filter(n->n.startsWith("신"))
                .forEach(n-> System.out.println(n));
    }
}
