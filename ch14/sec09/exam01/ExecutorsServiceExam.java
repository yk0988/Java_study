package ch14.sec09.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsServiceExam {
    public static void main(String[] args) {

        String[][] mails = new String[1000][3];

        // 배열 초기화
        for (int i = 0; i < mails.length; i++) {
            mails[i][0] = "ad@my.com";
            mails[i][1] = "member" + i + "@my.com"; // 이메일 형식 수정
            mails[i][2] = "신상품";
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 작업 제출
        for (int i = 0; i < mails.length; i++) {
            final int idx = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    String from = mails[idx][0];
                    String to = mails[idx][1];
                    String content = mails[idx][2];
                    System.out.println("[" + thread.getName() + "] " + from + " ==> " + to + ": " + content);
                }
            });
        }

        // 모든 작업을 제출한 후에 스레드 풀 종료
        executorService.shutdown();
    }
}
