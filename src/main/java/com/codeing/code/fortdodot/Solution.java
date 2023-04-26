package com.codeing.code.fortdodot;

import java.util.*;

/**
 *     이진트리 주차장
 *     0 이 출입구
 *     Level1 : 0
 *     level2 : 1,2
 *     level3 : 1-> 3,4
 *
 *     현재 1,3번에 자동차 주차되어있고 3번에 주차되어있다면 1번때문에 나갈수없기때 조건에 부합하지 않습니다.
 *     주차조건에 맞는 노드는 아래와같습니다.
 *     3,4
 *     2,3
 *     2,4
 *     1,2
 *
 *     제한사항
 *     - 주차 공간을 나타내는 노드 개수가 N개일떄 각주차 공간에는 0부터 N-1 까지 번호가 하나씩 붙어있다.
 *     - 파킹은 이진트리가 담긴 이차원 배열형태이다.
 *     - 파킹의 i번째 행은 i번 노드의 [ 왼쪽 자식노드번호, 오른쪽 자식노드번호] 입니다.
 *     - 해당 위치 자식노드가 없는 경우 -1이 담겨있다.
 *     - 파킹 의 행길이 는 3이상 200000이하이다
 *     - 이진트리 루트노드는 항상 0번노드
 *     따라서 주차입구 출구는 항상 0노드
 *     0번 노드에서 출발한 자동차가 도달할수 없는 노드는 없다.
 *     - 만약 자동차를 주차할수 있는 방법이 없다면 0 리턴*
 */
public class Solution {

    public long solution(int[][] parking) {
        int n = parking.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (parking[i][0] == -1 && parking[i][1] == -1) {
                continue;
            }
            map.computeIfAbsent(parking[i][0], k -> new ArrayList<>()).add(i);
            map.computeIfAbsent(parking[i][1], k -> new ArrayList<>()).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : map.getOrDefault(curr, Collections.emptyList())) {
                if (visited.contains(i)) {
                    continue;
                }
                int left = parking[i][0], right = parking[i][1];
                if ((left == -1 || visited.contains(left)) && (right == -1 || visited.contains(right))) {
                    visited.add(i);
                    if (left != -1) {
                        queue.offer(left);
                    }
                    if (right != -1) {
                        queue.offer(right);
                    }
                    cnt++;
                }
            }
        }
        return cnt == n - 1 ? (long) n * (n - 1) / 2 - cnt : 0;
    }


    public static void main(String[] args) {
        int[][] parking = {{1, 2}, {3, 4}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};
        Solution solution = new Solution();
        long count = solution.solution(parking);
        System.out.println(count);  // expected output: 4
    }


}
