package sec05;

public class infinity {
    public static void main(String[] args) {
        int x = 5;
        double y = 0.0;
        double z = x/y;

        System.out.println( z+2 );

        if(Double.isInfinite(z)|| Double.isNaN(z)){
            System.out.println("값 계산 불가");
        }else{
            System.out.println(z+2);
        }
    }
}
//논리연산자
//초과 > 이하 <=
//이상 >= 미만 <
//논리 : 같지않다 !=
//      and&&
//비트(2진수) : NOT같지 않다 ~=   >숫자가 존재함
//         XOR ^=
//          and&
//          OR |
//산술> 관계> 논리(일반, 이진)