package ch04.sec02;

public class switchcase { public static void main(String[] args) {
    int score = 73; // 점수 입력란

    // 점수를 10으로 나눈 값으로 switch-case 사용
    switch (score / 10) {
        case 10: // 점수 100인 경우 , 케이스는 한가지 조건에 대한 결과//
        case 9:
            System.out.println("점수가 90보다 큽니다");
            System.out.println("등급은 A입니다");
            break;  //break; < 걸면 한블럭만 실행됨/

        case 8:
            System.out.println("점수가 80보다 큽니다");
            System.out.println("등급은 B입니다");
            break;

        case 7:
            System.out.println("점수가 70보다 큽니다");
            System.out.println("등급은 C입니다");
            break;

        case 6:
            System.out.println("점수가 60보다 큽니다");
            System.out.println("등급은 D입니다");
            break;

        default:
            System.out.println("점수가 60보다 작습니다");
            System.out.println("등급은 F입니다");
            break;
    }
}
}
