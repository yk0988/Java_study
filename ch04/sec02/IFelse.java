package ch04.sec02;

public class IFelse {public static void main(String[] args) {
    int score=100; //점수입력란//

         //조건//
    if (score >=90) {
        System.out.println("점수가 90보다 큽니다");
        System.out.println("등급은 A입니다");

    }else if (score >=90){
        System.out.println("점수가 80보다 큽니다");
        System.out.println("등급은 B입니다");
    
    }else if (score >=90){
        System.out.println("점수가 70보다 큽니다");
        System.out.println("등급은 C입니다");
    
    }else if (score >=90){
        System.out.println("점수가 60보다 큽니다");
        System.out.println("등급은 D입니다");
    
    }else {
        System.out.println("점수가 60보다 작습니다");
        System.out.println("등급은 F입니다");
    }

}
}
