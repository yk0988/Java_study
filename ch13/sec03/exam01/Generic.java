package ch13.sec03.exam01;

public class Generic {

    // 제네릭 메서드 boxing: 타입 T의 값을 받아 Box<T> 객체를 반환
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>(); // 새로운 Box 객체 생성
        box.set(t); // 전달된 값을 Box에 저장
        return box; // Box 객체 반환
    }

    public static void main(String[] args) {
        // Integer 타입의 값을 boxing 메서드를 통해 Box에 저장
        Box<Integer> box1 = boxing(100);
        int intValue = box1.get(); // Box에서 Integer 값 꺼내기
        System.out.println(intValue); // 꺼낸 값 출력

        // String 타입의 값을 boxing 메서드를 통해 Box에 저장
        Box<String> box2 = boxing("철수");
        String strValue = box2.get(); // Box에서 String 값 꺼내기
        System.out.println(strValue); // 꺼낸 값 출력
    }
}
