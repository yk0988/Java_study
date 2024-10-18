package ch05.sec07;

public class MultidimensionaArrayCreateByValueList {
    public static void main(String[] args) {
        int[][] scores = {
                {80, 90, 96},
                {76, 88}
        };

        //배열의 길이
        System.out.println("1차원 배열 길이(반의 수):" + scores.length);
        System.out.println("2차원 배열 길이(첫 번째 반 학생 수):" + scores[0].length);
        System.out.println("2차원 배열 길이(두 번째 반 학생 수):" + scores[1].length);

        //첫째 반의 세번쨰 학생 점수 읽기
        System.out.println("scores[0][2]:" + scores[0][2]);
        //두번째 반의 세번쨰 학생 점수 읽기
        System.out.println("scores[1][1]:" + scores[1][1]);

        //1반//
        int class1Sum = 0;
        for (int i = 0; i < scores[0].length; i++) {
            class1Sum += scores[0][i];
        }
        double class1Avg = (double) class1Sum / scores[0].length;
        System.out.println("첫번째 반의 평균: " + class1Avg);

        //2반//
        int class2Sum = 0;
        for (int i = 0; i < scores[1].length; i++) {
            class2Sum += scores[1][i];
        }
        double class2Avg = (double) class2Sum / scores[1].length;
        System.out.println("첫번째 반의 평균: " + class2Avg);


        int totalStudent = 0;
        int totalSum = 0;
        for(int i = 0; i < scores.length; i++) {
            totalStudent += scores[i].length;
            for(int k = 0; k < scores[i].length; k++){
                totalSum += scores[i][k];
            }
        }

        double totalAvg = (double) totalSum / totalStudent;
        System.out.println("전체 학생의 평균 점수: " + totalAvg);
    }
}