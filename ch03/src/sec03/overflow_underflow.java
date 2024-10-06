package sec03;
//overflow/underflow//
public class overflow_underflow {
    public static void main(String[] args) {
        byte var1 =125;
        for(int i=0; i<5; i++){
            var1++;
            System.out.println("var1:"+var1);
        }

        //for(초기값;조건;증가)//
        //초기값 :int i = 0; -> i<5
        //조건 : int = i <5; -> i<=5
        //증가 : i++; ++i; //

        //초기값을 0으로 주는 이유는?


        System.out.println("------------------------------------------");
        byte var2 =125;
        for(int i=0; i<5; i++){
            var1--; //-126
            System.out.println("var1:"+var1);
        }
        
        //1바이트= -128~+127까지임 127을 초과 하면 -128 -127 -126 오버플로어
        // -128을 감소하면 127 126 125 언더플로어

    }
}
