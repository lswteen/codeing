package com.codeing.code.leetcode;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = {};

        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    answer = new int[]{i,j};
                    break;
                }
            }
        }
        return answer;
    }
}
