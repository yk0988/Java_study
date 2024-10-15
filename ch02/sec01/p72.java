public class p72 {
    public static void main(String[] args) {
    //강제 타입 변환//

                //정수//
                int value=123;
                System.out.printf("상품의 가격 :%d원\n", value);
                System.out.printf("상품의 가격 :%6d원\n", value);
                System.out.printf("상품의 가격 :%-6d원\n", value);
                System.out.printf("상품의 가격 :%06d원\n", value);

                // 실수 //
                double area = 3.14159 * 10 * 10;
                System.out.printf("반지름이 %d인 원의 넓이 : %10.2f\n", 10, area);

                // 문자열 //
                String name = "홍길동";
                String job = "도적";
                System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
            }
        }
