package ch04.sec04;

public class forx {
    public static void main(String[] args) {

//                for (int m = 2; m <= 9; m++) {
//                    System.out.print("*** " + m + "단 *** ");
//                    for (int n = 1; n <= 9; n++) {
//                        System.out.print(n + "x" + m + "=" + (n * m) + " ");
//                    }
//                    System.out.println(); // 각 단이 끝난 후 줄 바꿈
//                }
//            }
//        }



                for(int k=0;k<2;k++) {

                    for(int j=1; j<=9 ; j++) {
                        for(int i=2+(k*4); i<=5+(k*4); i++) {
                            System.out.print(i+" x "+j+" = "+ String.format("%2d", i*j) + "   ");
                            //System.out.printf("%d x %d = %2d  ",i,j,i*j);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        }

    // 1. 외부 반복문 (for(int k=0; k<2; k++))
    //이 반복문은 두 번 반복됩니다 (k = 0과 k = 1).
    //각 반복에서 다른 구구단의 범위를 출력합니다.
    //        2. 중간 반복문 (for(int j=1; j<=9; j++))
    //이 반복문은 j를 1부터 9까지 반복합니다.
    //j는 곱하는 숫자로, 각 구구단의 1단부터 9단까지의 곱을 출력하는 역할을 합니다.
    //3. 내부 반복문 (for(int i=2+(k*4); i<=5+(k*4); i++))
    //이 반복문은 i의 범위를 설정합니다. k의 값에 따라 i의 시작과 끝 값이 달라집니다.
    //        **k = 0**일 때: i는 2부터 5까지 (2, 3, 4, 5)
    //**k = 1**일 때: i는 6부터 9까지 (6, 7, 8, 9)

//출력부분
//각 i와 j의 곱을 계산하여 출력합니다.
//        String.format("%2d", i*j)는 결과를 2자리로 포맷팅하여 출력합니다. 1자리일 경우, 앞에 공백이 추가됩니다.
//        5. 줄 바꿈
//System.out.println();은 각 j의 반복이 끝난 후 줄을 바꿉니다.
//        System.out.println(); (이중) 은 각 k의 반복이 끝난 후에도 줄을 바꿉니다.