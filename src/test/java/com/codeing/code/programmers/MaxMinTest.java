package com.codeing.code.programmers;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

@SpringBootTest
class MaxMinTest {

    public String solution(String s){
        var answer ="1 2 3 4";
        var strList = s.split(" ");
        var numList = Arrays.stream(strList)
                .map(v-> Integer.parseInt(v))
                .collect(Collectors.toList());
        var min = numList.stream().collect(Collectors.minBy(
                Comparator.comparingInt(v->v)
        )).get();
        var max = numList.stream().collect(Collectors.maxBy(
                Comparator.comparingInt(v->v)
        )).get();
        return min+" "+max;
    }

    @Test
    void maxmin(){
        var s = "1 2 3 4";
        var answer = solution(s);
        System.out.println(answer);
    }

}