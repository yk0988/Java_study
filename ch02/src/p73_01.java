import java.util.Scanner;

public class p73_01 {
    public static void main(String[] args) {
        // 키보드 입력 데이터를 변수에 저장
        Scanner scanner = new Scanner(System.in);

        // 무한 루프
        while (true) {
            System.out.print("입력 문자열: ");  // 입력을 위한 메시지 출력
            String data = scanner.nextLine();  // 문자열 입력 받기

            // 입력이 "Q"일 경우 루프 종료
            if (data.equals("q")) {
                break;
            }

            // 입력한 문자열을 출력
            System.out.println("출력 문자열: " + data);
            System.out.println();  // 빈 줄 추가로 가독성 향상
        }

        // Scanner 객체 닫기
        scanner.close();
    }
}