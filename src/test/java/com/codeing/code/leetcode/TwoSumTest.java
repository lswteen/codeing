package com.codeing.code.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class TwoSumTest {
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

    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            //9-2 7, 0
            //9-7 2, 1
            //9-11 -2, 2
            //9-15 -6, 3
            map.put(target - nums[i], i);

        }

        return new int[]{};
    }

    @Test
    void twoSumTest(){
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] testValue = new int[]{0,1};

        assertArrayEquals(twoSum(nums,target),testValue);
    }

    @Test
    void twoSumMapTest(){
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 26;

        int[] testValue = new int[]{2,3};

        assertArrayEquals(twoSumMap(nums,target),testValue);
    }
}