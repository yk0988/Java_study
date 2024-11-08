package ch17.sec10;

import java.util.Arrays;

public class Aggregate {
    public static void main(String[] args) {
        int[]arr ={1,2,3,4,5};

        //카운팅
        long count = Arrays.stream(arr)
                .filter(n -> n%2 ==0)
                .count();
        System.out.println("2의 배수 : " + count)
        ;

        //총합
        long sum = Arrays.stream(arr)
                .filter(n -> n%2 ==0)
                .sum();
        System.out.println("2의 배수 합 : " + sum);


        //평균
        double avg = Arrays.stream(arr)
                .filter(n -> n%2 ==0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수 평균 : " + avg);



        //최대값
        int max = Arrays.stream(arr)
                .filter(n -> n%2 ==0)
                .max()
                .getAsInt();
        System.out.println("최대 : " + max);


        //최소값
        int min = Arrays.stream(arr)
                .filter(n -> n%2 ==0)
                .min()
                .getAsInt();
        System.out.println("최소 : " + min);


        //첫번쨰 요소
        int first =  Arrays.stream(arr)
                .filter(n -> n%3 ==0)
                .findFirst()
                .getAsInt();
        System.out.println("첫번째 3의 배수 : " + first);

    }
}
