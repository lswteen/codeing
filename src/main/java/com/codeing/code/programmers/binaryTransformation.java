package com.codeing.code.programmers;

import java.util.Arrays;

/**
 * 0을 제거 카운트, 문자열 길이, 문자열길이를 다시 이진수로 표기
 * 마지막에 1이 나올때까지 돌려
 */
public class binaryTransformation {
    public int[] solution(String s) {
        //s = "110010101001";
        int[] answer = {0,0};   //첫번째 배열은 이진변환 횟수, 두번째 배열은 0을 제거한 횟수
        while(!s.equals("1")){  //s문자열이 1이 아니면 무한으로 돌아라
            answer[0]++; //loop 돈만큼 증가
            answer[1] += s.chars().filter(c->c =='0').count();  //문자열을 IntStream 으로 변한후 필터에서 나오는 문자가 0이라면 0을 카운트
            s = Integer.toBinaryString(s.replaceAll("0","").length()); // 문자열에서 0을 리플레이스하고 남은 문자열 길이 10진수를 2진수로 변경 해서 S에 넣기
        }

        return answer;
    }


}
