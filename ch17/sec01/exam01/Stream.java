package ch17.sec01.exam01;

import java.util.HashSet;
import java.util.Set;

public class Stream {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용건");
        set.add("김자반");

        // Set에서 stream을 생성
        set.stream().forEach(name -> System.out.println(name));
    }
}
