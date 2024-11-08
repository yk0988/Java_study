package ch17.sec07.exam01;


public class Student implements Comparable<Student> {
    private String name; // 필드 선언 위치 수정
    private int score;   // 필드 선언 위치 수정

    // 생성자
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName(){return name;}
    public int getScore(){return score;}

    // compareTo 메서드 구현
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score); // 점수 기준으로 정렬
    }
}

