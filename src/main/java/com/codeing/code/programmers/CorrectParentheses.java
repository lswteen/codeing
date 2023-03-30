package com.codeing.code.programmers;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class CorrectParentheses {

    boolean solution_A(String s){
        boolean answer = true;
        if(s.substring(0,1).equals(")")){
            return false;
        }
        var list = s.split("");
        var a = Arrays.stream(list).filter(v-> v.equals("("))
                .collect(Collectors.toList());
        var b = Arrays.stream(list).filter(v->v.equals(")"))
                .collect(Collectors.toList());
        answer = a.size()/b.size()==1 ? true : false;
        return answer;
    }

    boolean solution(String s){
        Stack<Character> stack = new Stack<>();
        var chars = s.toCharArray();
        for (char c:chars) {
            if(c == '('){
                stack.push('(');
            }else if(c==')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        var c = new CorrectParentheses();
        boolean answer = c.solution(")()(");
        System.out.println(answer);
    }
}
