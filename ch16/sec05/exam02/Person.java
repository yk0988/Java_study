package ch16.sec05.exam02;

public class Person {
    // ordering 메서드: 두 문자열을 비교하는 메서드
    public void ordering(Comparble comparble){
        String a = " 홍길동";
        String b = " 김길동";

        // comparable의 compare 메서드를 사용하여 두 문자열을 비교
        int result = comparble.compare(a,b);

        if(result<0){
            System.out.println(a+"은"+b+" 보다 앞에 옵니다");
        }else if(result==0){
            System.out.println(a+"은"+b+"와 같습니다");
        }else {
            System.out.println(a+"은"+b+" 보다 뒤에 옵니다");
        }
    }
}
