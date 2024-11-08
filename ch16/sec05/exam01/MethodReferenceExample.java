package ch16.sec05.exam01;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // Person 클래스의 인스턴스 생성
        Person person = new Person();

        //정적 메소드일 경우
        //람다식
        //person.action((x,y)-> Computer.staticMethod(x,y));
        // 정적 메서드 참조: Computer 클래스의 staticMethod를 참조하여 action 메서드 호출
        person.action(Computer::staticMethod);

        // Computer 클래스의 인스턴스 생성
        Computer com = new Computer();

        //람다식
        //person.action((x,y)-> Com.instanceMethod(x,y));
        // 인스턴스 메서드 참조: com 인스턴스의 instanceMethod를 참조하여 action 메서드 호출
        person.action(com::instanceMethod);
    }
}
