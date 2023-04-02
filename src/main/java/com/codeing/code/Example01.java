package com.codeing.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * int grid[n][n] i행 j 열
 * int maxSum : 정수 모든 그리도 합산
 * 222 333 444 27  3*3 답이 3
 *
 * 9칸에 그리드 중 1*1 은 그리드에 합산이 4보다 작으면 0으로 표기
 * 14 sum 은 2*2 답은 2
 * Lagest Sub-Grid Sub-Grid
 *
 *
 * 222  333 444   27
 *
 * 작거나같다.
 * * * *
 */
public class Example01 {

    /*
     * Complete the 'largestSubgrid' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY grid
     *  2. INTEGER maxSum
     */

    public static int largestSubgrid(List<List<Integer>> grid, int maxSum) {
        int n = grid.size();
        int[][] prefixSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int val = grid.get(i - 1).get(j - 1);
                prefixSum[i][j] = val + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
        return IntStream.rangeClosed(1, n)
                .boxed()
                .flatMap(size -> IntStream.rangeClosed(size, n).boxed().flatMap(i ->
                        IntStream.rangeClosed(size, n).boxed().map(j ->
                                        prefixSum[i][j] - prefixSum[i - size][j] - prefixSum[i][j - size] + prefixSum[i - size][j - size])
                                .filter(sum -> sum <= maxSum)
                                .map(sum -> size)))
                .reduce((a, b) -> b)
                .orElse(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(2, 2, 2),
                Arrays.asList(3, 3, 3),
                Arrays.asList(4, 4, 4)
        );
        int maxSum1 = 3;
        int maxSum2 = 14;
        int maxSum3 = 27;

//        System.out.println(largestSubgrid(grid, maxSum1)); // 0
//        System.out.println(largestSubgrid(grid, maxSum2)); // 1
//        System.out.println(largestSubgrid(grid, maxSum3)); // 2

        System.out.println(largestSubgrid(grid, 14));
    }



}

//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int gridRows = Integer.parseInt(bufferedReader.readLine().trim());
//        int gridColumns = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> grid = new ArrayList<>();
//
//        IntStream.range(0, gridRows).forEach(i -> {
//            try {
//                grid.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        int maxSum = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int result = Result.largestSubgrid(grid, maxSum);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
