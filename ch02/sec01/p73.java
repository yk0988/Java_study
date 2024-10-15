import java.util.Scanner;

public class p73 {
    public static void main(String[] args) {
        //키보드 입력 데이터를 변수에 저장//
        Scanner scanner = new Scanner(System.in);

        System.out.println("x값 입력 : ");
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);
//strX라는 **문자열(String)**을 **정수(int)**로 변환하는 Java의 내장 메서드.//

        System.out.println("Y값 입력 : ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);


        int result = x + y;
        System.out.println("x + y:" + result);
        System.out.println();

    System.out.println("종료");
    }
        }
