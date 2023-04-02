package com.codeing.code;

import java.util.*;
import java.util.stream.*;

public class Example001 {
    public int[] solution(int n, int m) {
        List<Integer> nums = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int idx = 0;
        while (nums.size() > 1) {
            idx = (idx + m - 1) % nums.size();
            result.add(nums.remove(idx));
        }
        result.add(nums.get(0));

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution02(int n, int m) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int idx = 0;
        while (nums.size() > 1) {
            idx = (idx + m - 1) % nums.size();
            result.add(nums.remove(idx));
        }
        result.add(nums.get(0));

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }


    public int[] solution03(int n, int m) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        List<Integer> removedNumbers = new ArrayList<>();
        int currentIndex = 0;
        while (numbers.size() > 1) {
            currentIndex = (currentIndex + m - 1) % numbers.size();
            int removedNumber = numbers.remove(currentIndex);
            removedNumbers.add(removedNumber);
        }

        removedNumbers.add(numbers.get(0)); // 마지막으로 남은 숫자 추가

        // List to int[] 변환
        int[] result = new int[removedNumbers.size()];
        for (int i = 0; i < removedNumbers.size(); i++) {
            result[i] = removedNumbers.get(i);
        }

        return result;
    }

    public int[] solution04(int n, int m) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        List<Integer> removedNumbers = new ArrayList<>();
        int currentIndex = 0;
        while (numbers.size() > 1) {
            currentIndex = (currentIndex + m - 1) % numbers.size();
            int removedNumber = numbers.remove(currentIndex);
            removedNumbers.add(removedNumber);
        }

        // 마지막으로 남은 숫자 제거
        removedNumbers.add(numbers.get(0));
        removedNumbers.remove(removedNumbers.size() - 1);

        // List to int[] 변환
        int[] result = new int[removedNumbers.size()];
        for (int i = 0; i < removedNumbers.size(); i++) {
            result[i] = removedNumbers.get(i);
        }

        return result;
    }

    public int[] solution05(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int idx = 0;
        int[] result = new int[n];
        while (list.size() > 1) {
            idx = (idx + m - 1) % list.size();
            result[n - list.size()] = list.get(idx);
            list.remove(idx);
        }
        result[n - 1] = list.get(0);
        return result;
    }


    public static List<Integer> solution001(int n, int m) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> removedNumbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int index = 0;
        while (numbers.size() > 1) {
            index = (index + m - 1) % numbers.size();
            int removedNumber = numbers.remove(index);
            removedNumbers.add(removedNumber);
        }

        return removedNumbers;
    }


    public static void main(String[] args) {
        Example001 sol = new Example001();

        int n = 5, m = 2;
        List<Integer> ans = sol.solution001(n, m);

        System.out.println(ans.toString());
        // Add more test cases here
    }



}
