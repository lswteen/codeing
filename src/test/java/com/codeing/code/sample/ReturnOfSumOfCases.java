package com.codeing.code.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ReturnOfSumOfCases {

    @Test
    void contextLoads() {
        int request = 28;
        int target = 0;
        for(char c : String.valueOf(request).toCharArray()){
            target += c - '0';
        }

        for(int i = request + 1; i <= 150000; i++){
            int sum = 0;
            for(char c : String.valueOf(i).toCharArray()){
                sum += c - '0';
            }

            if(sum == target){
                System.out.println(i);
                break;
            }
        }
    }

    private int solutionOfSum(int N){
        int sum = 0;
        for (char c: String.valueOf(N).toCharArray()) {
            sum += c - '0';
        }

        int answer = 0;
        for (int i = N+1; i <=150000; i++) {
           int diff = 0;
           for(char c : String.valueOf(i).toCharArray()){
               diff += c - '0';
           }
           if(sum == diff){
               System.out.println("=====> "+i);
               answer = i;
               break;
           }
        }
        return answer;
    }


//    int N은 정수 N이 주어지면 N보다 큰 가장 작은 정수를 반환하고 자릿수의 합이 N의 자릿수와 같습니다.
//
//    예: N = 28이면 함수는 37을 반환해야 합니다.
//    28의 숫자의 합은  = 10이다.
//    다음 숫자는 29(11) 30(3) 31(4) 32(5) 33(6) 34(7) 35(8) 36(9) 37(10)이다. N734가 주어지면 함수는 743을 반환해야 합니다.
//
//    734와 743의 숫자의 합은 7+3+4= 7+4 + 3 = 14이다.
//    735와 742 사이의 다른 정수는 14
//
//    3. 더하지 않습니다. N = 1990이 주어지면 함수는 2089를 반환해야 합니다.
//    두 숫자의 숫자의 합은 19이고 숫자 합이 같은 다른 정수는 없습니다.
//
//4. N = 1000일 때 함수는 10000을 반환해야 합니다.
//    두 숫자의 숫자의 합은 1이고 숫자의 합이 같은 다른 정수는 없다.
//
//    다음과 같이 가정하자: · N은 [150,000] 범위 내의 정수이다.

    @Test
    void solution(){
        int answer = solutionOfSum(37);
        System.out.println(answer);
    }






//    이 함수는 N개의 정수(비감소 순서로 정렬됨)와 정수로 구성된 비어 있지 않은 배열 A가 주어지면
//    A가 숫자 1, 2,
//            ((1부터 K까지의 모든 숫자)를 포함하고 다른 숫자는 없는지 확인합니다.
//
//    예를 들어,
//    다음 배열 A와 K = 3이 주어지면, A[0] - 1 A[ ] = 1 A[2] = 2 A[3] = 3 A[4] - 3 함수는 true로 반환되어야 합니다.
//
//    다음 배열 A와 K = 2의 경우, A [ ] = 1 A [1] = 1 A [2] = 3은
//    함수가 false를 반환해야 합니다.
//
//    첨부된 코드는 일부 입력에 대해 여전히 올바르지 않습니다.
//    오류에도 불구하고 코드는 예시적인 시험 사례에 대한 정답을 산출할 수 있다.
//
//    이 연습의 목표는 구현에서 버그를 찾아 수정하는 것입니다.
//
//    최대 두 줄까지 수정할 수 있습니다.
//
//    다음과 같이 가정하자:
//
//    N과 K는 [1..] 범위 내의 정수이다.300,000];
//
//    배열 A의 각 원소는 [0.1,000,000,000] 범위의 정수;
//
//    배열 A는 감소하지 않는 순서로 정렬됩니다.
    private boolean methodA(int[] A, int K) {
        int n = A.length;
        for(int i =0; i < n-1;i++){
            if(A[i]+ 1 < A[i+1])
                return false;
        }
        if(A[0] !=1 && A[n-1] !=K)
            return false;
        else
            return true;
    }

    @Test
    void solutionB(){
        int[] A = {1,2,3};
        int K = 3;
        boolean answer = methodA(A,K);
        System.out.println(answer);
    }



}
