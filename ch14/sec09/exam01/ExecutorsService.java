package ch14.sec09.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsService {
    public static void main(String[] args) {
        // Fixed thread pool 생성
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        // 스레드 풀 종료
        executorService.shutdownNow();

    }
}