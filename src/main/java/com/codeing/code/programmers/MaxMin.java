package com.codeing.code.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MaxMin {
    public String solution(String s){
        var answer ="1 2 3 4";
        var strList = s.split("");
        var numList = Arrays.stream(strList)
                .map(v-> Integer.parseInt(v))
                .collect(Collectors.toList());
        var min = numList.stream().collect(Collectors.minBy(
                Comparator.comparingInt(v->v)
        )).get();
        var max = numList.stream().collect(Collectors.maxBy(
                Comparator.comparingInt(v->v)
        )).get();
        return min+"_"+max;
    }
}
