package com.codeing.code.yanolza;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class quiz01Test {
    @Test
    public void testSolution() {
        quiz01 solution = new quiz01();

        int[] A1 = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        assertEquals(4, solution.solution(A1));

        int[] A2 = {5, 4, 3, 2, 1};
        assertEquals(1, solution.solution(A2));

        int[] A3 = {1, 2, 3, 4, 5};
        assertEquals(1, solution.solution(A3));

        int[] A4 = {-3, -3};
        assertEquals(1, solution.solution(A4));

        int[] A5 = {0, 0, 0, 0};
        assertEquals(0, solution.solution(A5));
    }

}