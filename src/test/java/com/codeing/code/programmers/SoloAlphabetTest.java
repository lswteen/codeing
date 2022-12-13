package com.codeing.code.programmers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 프로그래머스 문제
 * 2회이상 나타난 알파뱃 2개이상 부분으로 나눠있으면 외톨이 알파뱃
 * https://school.programmers.co.kr/learn/courses/15008/lessons/121683?language=java
 *
 * https://taehoung0102.tistory.com/220
 */
@SpringBootTest
class SoloAlphabetTest {
    public String solution(String s) {
        String answer = "";
        int n = s.length();

        //2개 이하일때는 주변만 탐색
        //2개 이상일때는 문자덩어리로 만들어서 같은 문자열이 있는지 검색 lastOf로


//        for (int j=0, i=0; j<n; j++){
//            System.out.println("str : "+ (j+1) +" : "+s.charAt(j));
//        }

        char str;
        int i = 0;
        while(i < n){
            str = s.charAt(i);
            //System.out.println("str : "+str);
            if(i != 0 && i < n-1 ){
                char befor = s.charAt(i-1);
                char self = s.charAt(i);
                char after = s.charAt(i+1);
                System.out.println(befor +"::"+self+"::"+after);
            }
            i++;
        }

        return answer;
    }


    public String solutionB(String s){
        String answer = "";
        Map<Character, Boolean> map = new HashMap<>();   //외톨이 판별 map
        Set<Character> set = new TreeSet<>();  //중복 판별

        char[] charArray = s.toCharArray();
        char current =' ';
        for (char temp:charArray) {
            if(current != temp){
                if(map.containsKey(temp)){
                    set.add(temp);
                }
                map.put(temp,true);
                current = temp;
            }
        }
        for(char temp:set){
            answer +=temp;
        }
        if(answer==""){
            return "N";
        }
        return answer;
    }

    @Test
    public void soloAlphabet(){
        String answer = solutionB("eeddee");
        assertThat(answer).isEqualTo("ee");
    }

}