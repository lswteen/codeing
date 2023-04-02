package com.codeing.code;
import java.util.*;
import java.util.stream.*;

public class Example002 {
    public int solution(int[] scores, int k) {
        int left = 0, right = Arrays.stream(scores).max().getAsInt() - Arrays.stream(scores).min().getAsInt();
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int minVal = scores[0], maxVal = scores[0];
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] < minVal) {
                    minVal = scores[i];
                }
                if (scores[i] > maxVal) {
                    maxVal = scores[i];
                }
                if (maxVal - minVal > mid) {
                    cnt++;
                    minVal = scores[i];
                    maxVal = scores[i];
                }
            }
            if (cnt > k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Example002 sol = new Example002();

        // Example 1
        int[] scores1 = {1, 3, 7, 8, 10, 15};
        int k1 = 3;
        int expected1 = 5;
        int result1 = sol.solution(scores1, k1);
        System.out.println(result1 == expected1 ? "Test case 1 passed" : "Test case 1 failed");

        // Example 2
        int[] scores2 = {1, 2, 12, 14, 15};
        int k2 = 2;
        int expected2 = 4;
        int result2 = sol.solution(scores2, k2);
        System.out.println(result2 == expected2 ? "Test case 2 passed" : "Test case 2 failed");
    }
}
