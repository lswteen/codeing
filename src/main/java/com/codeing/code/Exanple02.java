package com.codeing.code;

import java.util.Arrays;

public class Exanple02 {

//    public int[] solution(int[][] v){
//        int[] answer = new int[2];
//        int[] x = new int[3];
//        int[] y = new int[3];
//
//        // x좌표와 y좌표를 분리하여 저장
//        for(int i=0; i<3; i++){
//            x[i] = v[i][0];
//            y[i] = v[i][1];
//        }
//
//        // 대각선상의 좌표를 찾아서 저장
//        int x4 = 0, y4 = 0;
//        if(x[0] == x[1]) x4 = x[2];
//        else if(x[0] == x[2]) x4 = x[1];
//        else if(x[1] == x[2]) x4 = x[0];
//
//        if(y[0] == y[1]) y4 = y[2];
//        else if(y[0] == y[2]) y4 = y[1];
//        else if(y[1] == y[2]) y4 = y[0];
//
//        // 나머지 한 점의 좌표 저장
//        answer[0] = x4;
//        answer[1] = y4;
//
//        return answer;
//    }

    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        int[] x = Arrays.stream(v).mapToInt(arr -> arr[0]).toArray();
        int[] y = Arrays.stream(v).mapToInt(arr -> arr[1]).toArray();

        int x4 = Arrays.stream(x).reduce(0, (a, b) -> a ^ b ^ Arrays.stream(x).filter(i -> i != a && i != b).findFirst().getAsInt());
        int y4 = Arrays.stream(y).reduce(0, (a, b) -> a ^ b ^ Arrays.stream(y).filter(i -> i != a && i != b).findFirst().getAsInt());

        answer[0] = x4;
        answer[1] = y4;

        return answer;
    }


    public static void main(String[] args) {
        Exanple02 exanple02 = new Exanple02();
        int[][] v = {{1,4},{3,4},{3,10}};
        int[] answer = exanple02.solution(v);
        System.out.println(Arrays.toString(answer));
    }
}
