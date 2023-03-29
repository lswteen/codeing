package com.codeing.code.programmers;

import java.util.Arrays;

/**
 * 배열 A, B의 크기 : 1,000 이하의 자연수
 * 배열 A, B의 원소의 크기 : 1,000 이하의 자연수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 * 최솟값
 */
public class Minimum {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int num = A.length -1;
        for (int i = 0; i <A.length ; i++) {
            answer += (A[i] * B[num--]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Minimum minimum= new Minimum();
//        int[] A = {1,4,2};
//        int[] B = {5,4,4};
        int[] A = {1,2};
        int[] B = {3,4};
        System.out.println(minimum.solution(A,B));
    }
}
