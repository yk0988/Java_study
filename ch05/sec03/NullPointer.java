package ch05.sec03;

public class NullPointer {
    public static void main(String[] args) {
/*
        int[] intArray = null;
        intArray[0] =10;

        String str = null;
        System.out.println("총 문자수:"+str.length());
    }
}
*/
        // 크기가 1인 int 배열 초기화
        int[] intArray = new int[1];
        intArray[0] = 10;  // 이제 정상 작동합니다.

        // 빈 문자열로 초기화
        String str = "0";
        System.out.println("총 문자수: " + str.length());  // 이 경우 0이 출력됩니다.

        // 비어 있지 않은 문자열로 설정하고 싶다면:
        str = "안녕";
        System.out.println("총 문자수: " + str.length());  // 문자열의 길이를 출력합니다.
    }
}

/*


        int[] intArray = null;

        // intArray가 null인지 체크
        if (intArray == null) {
            intArray = new int[1]; // 배열 초기화
        }
        intArray[0] = 10; // 배열에 값 할당

        String str = null;

        // str이 null인지 체크
        if (str == null) {
            str = ""; // 빈 문자열로 초기화
        }
        System.out.println("총 문자수: " + str.length()); // 빈 문자열의 길이는 0입니다.
    }
}
*/
