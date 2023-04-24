package com.codeing.code.yanolza;

public class quiz01 {
    public int solution(int[] A) {
        int count = 0;
        int n = A.length;

        if (n < 3) { // 배열의 크기가 3 미만인 경우, 언덕과 계곡이 없음
            return 0;
        }

        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && A[i] == A[i + 1]) { // 동일한 높이의 세그먼트를 건너뛰기
                i++;
            }

            int j = i + 1; // 언덕/계곡의 시작 지점
            if (j == n - 1) { // 배열의 마지막 세그먼트인 경우
                break;
            }

            if (A[j] > A[i]) { // 언덕인 경우
                while (j < n - 1 && A[j] < A[j + 1]) {
                    j++;
                }
                count++;
            } else { // 계곡인 경우
                while (j < n - 1 && A[j] > A[j + 1]) {
                    j++;
                }
                count++;
            }
            i = j;
        }
        return count;
    }
}
