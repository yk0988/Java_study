package sec08;
//bit logic//

//시프트 연산자
//> 오른쪽으로 이동 : /2
//> 왼쪽으로 이동 : *2
// : 리다이렉션 기호: 출력 방향을 변경
//<< >> : 쉬프트 연산자

//증감/감소 연산자
//a= a+1 -> a++
//b= b-1 -> b--

//대입연산//
//a= a+1 -> a+=1
//b= b+5 -> b-=5
//a=a*5 -> a*=5

public class p99 {
    public static void main(String[] args) {
        System.out.println(" 45 & 25 =" +(45&25));
        System.out.println(" 45 | 25 =" +(45|25));
        System.out.println(" 45 ^ 25 =" +(45^25));
        System.out.println(" ~45 = " +(~45));
        System.out.println("-------------------");

        byte receiveData = -120;

        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);


        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsignedInt2);

        int test = 136;
        byte btest =(byte) test;
        System.out.println(btest);

    }
}
