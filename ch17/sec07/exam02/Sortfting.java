package ch17.sec07.exam02;

import ch17.sec07.exam01.Student;
import java.util.ArrayList;
import java.util.List;

public class Sortfting { // 클래스 이름 수정
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 30));
        studentList.add(new Student("신용건", 10));
        studentList.add(new Student("미선씨", 20));

        // 오름차순 정렬
        System.out.println("점수 오름차순:");
        studentList.stream()
                .sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

        System.out.println(); // 줄 바꿈

        // 내림차순 정렬
        System.out.println("점수 내림차순:");
        studentList.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
    }
}

