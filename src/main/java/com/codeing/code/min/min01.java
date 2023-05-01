package com.codeing.code.min;

import java.util.Arrays;
import java.util.Optional;

public class min01 {
    private static final String comam= ",";
    public String solution(String[] args){

        Optional<String> result = Arrays.stream(args)
                .map(String::toUpperCase)
                .filter(s->s.length() >=5 && s.length() <= 10)
                .findFirst();

        return result.orElse("없음");
    }

    public static void main(String[] args) {
        min01 min01 = new min01();
        String[] str = {"hello","world","aaabbbcccEEEdddfff"};
        System.out.println(" str : "+min01.solution(str));
    }
}
