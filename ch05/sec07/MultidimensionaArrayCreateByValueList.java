public class MultidimensionaArrayCreateByValueList {
    public static void main(String[] args) {
        // 2차원 배열 scores 선언 및 초기화
        int[][] scores = {
                {80, 90, 96},  // 첫 번째 반의 점수
                {76, 88}       // 두 번째 반의 점수
        };

        // 배열의 길이 출력
        System.out.println("1차원 배열 길이(반의 수):" + scores.length);
        System.out.println("2차원 배열 길이(첫 번째 반 학생 수):" + scores[0].length);
        System.out.println("2차원 배열 길이(두 번째 반 학생 수):" + scores[1].length);

        // 첫째 반의 세 번째 학생 점수 출력
        System.out.println("scores[0][2]:" + scores[0][2]); // 96
        // 둘째 반의 두 번째 학생 점수 출력
        System.out.println("scores[1][1]:" + scores[1][1]); // 88

        // 첫 번째 반의 평균 점수 계산
        int class1Sum = 0;
        for (int i = 0; i < scores[0].length; i++) {
            class1Sum += scores[0][i];  // 첫 번째 반 점수 합계: 80 + 90 + 96 = 266
        }
        double class1Avg = (double) class1Sum / scores[0].length;  // 첫 번째 반의 평균: 266 / 3 = 88.67
        System.out.println("첫번째 반의 평균: " + class1Avg);

        // 두 번째 반의 평균 점수 계산
        int class2Sum = 0;
        for (int i = 0; i < scores[1].length; i++) {
            class2Sum += scores[1][i];  // 두 번째 반 점수 합계: 76 + 88 = 164
        }
        double class2Avg = (double) class2Sum / scores[1].length;  // 두 번째 반의 평균: 164 / 2 = 82.0
        System.out.println("두번째 반의 평균: " + class2Avg);

        // 전체 학생의 점수 합계 및 평균 계산
        int totalStudent = 0;
        int totalSum = 0;
        for (int i = 0; i < scores.length; i++) {  // 반을 반복
            totalStudent += scores[i].length;  // 총 학생 수: 3 + 2 = 5
            for (int k = 0; k < scores[i].length; k++) {  // 각 학생의 점수를 더함
                totalSum += scores[i][k];  // 총 점수: 266 + 164 = 430
            }
        }

        double totalAvg = (double) totalSum / totalStudent;  // 전체 평균: 430 / 5 = 86.0
        System.out.println("전체 학생의 평균 점수: " + totalAvg);
    }
}


//1차원 배열 길이(반의 수):2
//        2차원 배열 길이(첫 번째 반 학생 수):3
//        2차원 배열 길이(두 번째 반 학생 수):2
//scores[0][2]:96
//scores[1][1]:88
//첫번째 반의 평균: 88.66666666666667
//두번째 반의 평균: 82.0
//전체 학생의 평균 점수: 86.0


