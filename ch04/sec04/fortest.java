package ch04.sec04;

public class fortest {
        public static void main(String[] args) {

            for (int i = 1; i <=10; i++)
                System.out.print(i + "  ");

            System.out.println(); // 줄바꿈

            // 1부터 10까지 출력
            for (int i = 0; i < 10; i++)
                System.out.print((i + 1) + "  ");
        }
    }
//효율성: 성능 차이는 미미하므로 둘 다 효율적입니다.
//사용 편의성: 코드의 의도에 따라 첫 번째 for 문이 더 직관적이고 명확할 수 있습니다.