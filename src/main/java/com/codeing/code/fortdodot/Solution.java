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

    /**
     * 이 문제에서는 이진 트리 형태의 주차장에서 두 대의 차량이 서로의 입구/출구 경로를 막지 않는 방법의 수를 찾아야 합니다.
     *
     * 이 문제를 해결하기 위해, 트리의 각 서브트리에서 노드 수를 계산하는 깊이 우선 탐색 (DFS)을 수행할 수 있습니다.
     * 그런 다음, 각 서브트리의 노드 수를 사용하여 주차장에서 서로의 길을 막지 않고 두 대의 차를 주차하는 방법의 수를 계산합니다.
     * @param parking
     * @return
     */
    public long solution(int[][] parking) {
        long[] count = new long[parking.length];

        // 각 서브트리의 노드 수를 계산하기 위해 깊이 우선 탐색 (DFS)을 수행합니다.
        dfs(0, count, parking);

        // 주차장에서 서로의 길을 막지 않고 두 대의 차를 주차하는 방법의 수를 계산합니다.
        long answer = 0;
        for (int i = 0; i < parking.length; i++) {
            if (parking[i][0] != -1 && parking[i][1] != -1) {
                answer += count[parking[i][0]] * count[parking[i][1]];
            }
        }

        return answer;
    }

    // 깊이 우선 탐색 함수로, 각 서브트리의 노드 수를 계산합니다.
    private void dfs(int node, long[] count, int[][] parking) {
        count[node] = 1;

        for (int child : parking[node]) {
            if (child != -1) {
                dfs(child, count, parking);
                count[node] += count[child];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] parking1 = {{1, 2}, {3, 4}, {-1, -1}, {-1, -1}, {-1, -1}};
        long result1 = solution.solution(parking1);
        System.out.println(result1);  // answer: 4

        int[][] parking2 = {{1, 2}, {3, 4}, {5, 6}, {-1, 7}, {8, 9}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};
        long result2 = solution.solution(parking2);
        System.out.println(result2);  // answer: 26
    }



}
