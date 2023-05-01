package com.codeing.code.fortdodot;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/**
 * 소셜 미디어 상 친구일 가능성이 가장 높은 유저를 친구로 추천하는 기능을 만들려고 합니다.
 * 이때 친구가 아닌 유저중 mutual friend 가 많을수록 친구일 가능성이 높다고 봅니다.
 *
 * 예를들어 친구관계가 다음과 같다면
 * david 와 frank 가 친구
 * demi 와 david 가 친구
 * frank 와 james 가 친구
 * demi 와 james가 친구
 * claire 와 frank 가 친구
 *
 * david 와 james 의 mutual friend 2명 ( frank 와 demi)
 * david 와 claire 의 mutual friend 는 1명 (frank)
 * 이므로 david 와 친구일 가능성이 높은 유저는 james 입니다.
 * (이미 david와 친구인 frank 와 demi 는 추천대상이 아닙니다.)
 *
 * 소셜 미디어상에서 친구관계를 담은 리스트 friends 와 친구 추천 대상의 아이디 user_id 가 주어질때 , 누구를 친구로 추천해줘야하는지 구하는 함수 solution 완성해주세요
 *
 * class Solution {
 *     public String[] solution(String[][] friends, String user_id) {
 *         String[] answer = {};
 *         return answer;
 *     }
 * }
 *
 * 제한사항
 * friends 길이는 10000 이하인 리스트
 *
 * friends 원소는 x,y 형태이며 이는 아이디가 x인 유저와 아이디가 y 인 유저가 소셜미디어 상에서 친구라는 뜻입니다.
 * x와 y의 길이가 1이상 20이하인 소문자 문자열입니다.
 *
 * 동일한 친구관계가 중복해서 주어지지 않습니다.
 *
 * user_id길이가 1이상 20이하 소문자 문자열입니다.
 * 친구가 없는 유저는 없습니다.
 * 따라서 friends 에서 적어도 한번은 나오는 아이디가 user_id로 주어집니다.
 * 모든유저아이디는 알파벳 소문자로만 이루어져 있습니다.
 * 친구일 가능성이 가장높은 유저가 여럿일경우 유저의 id를 오름차순으로 정렬해 리턴합니다.
 * mutual friend가 한명도 없는 경우는 주어지지 않습니다.
 *
 * 입출력 예
 * friends :
 * [["david","demi"],["frank","demi"],["demi","james"]]
 * user_id :
 * "frank"
 * return :
 * ["david","james"]
 *
 *
 * 입출력 예2 번째
 * frank와 david 의 mutual friend 는 1명 (demi)
 * frank 와 james 의 mutual friend 는 1명(demi)
 *
 * 따라서 이경우 david 와 james 모두  추천해야합니다.
 *
 * 서로 친구가 아닌 두이용자의 동시에 친구인 다른 이용자가 있을때, 이이용자를 mutual friend 라고 합니다.
 * 예를 들어 A와B친구이고 B와C가 친구이지만 C와A는 친구가 아닐때 B는 A와 C mutual friend입니다.
 *
 * java8버전으로 부탁해여*
 */
public class example03 {

    public static void main(String[] args) {
        example03 solution = new example03();

        String[][] parking1 = {{"david","frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}};
        String[] result1 = solution.solution(parking1, "david");
        System.out.println(Arrays.toString(result1));  // 출력: 4

        String[][] parking2 = {{"david","demi"}, {"frank", "demi"}, {"demi", "james"}};
        String[] result2 = solution.solution(parking2, "frank");
        System.out.println(Arrays.toString(result2));  // 출력: ["david", "james"]

    }

    public String[] solution(String[][] friends, String user_id) {
        Map<String, List<String>> map = makeMap(friends);
        List<String> userFriends = map.get(user_id);

        Map<String, Integer> mutualFriends = new HashMap<>();
        for (String friend : userFriends) {
            List<String> friendFriends = map.get(friend);
            for (String mutualFriend : friendFriends) {
                if (!mutualFriend.equals(user_id) && !userFriends.contains(mutualFriend)) {
                    mutualFriends.put(mutualFriend, mutualFriends.getOrDefault(mutualFriend, 0) + 1);
                }
            }
        }

        List<String> recommendFriends = new ArrayList<>();
        int max = -1;
        for (Map.Entry<String, Integer> entry : mutualFriends.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                recommendFriends.clear();
                recommendFriends.add(entry.getKey());
            } else if (entry.getValue() == max) {
                recommendFriends.add(entry.getKey());
            }
        }

        Collections.sort(recommendFriends);
        return recommendFriends.toArray(new String[0]);
    }

    private Map<String, List<String>> makeMap(String[][] friends) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] pair : friends) {
            String user1 = pair[0];
            String user2 = pair[1];

            map.putIfAbsent(user1, new ArrayList<>());
            map.putIfAbsent(user2, new ArrayList<>());

            map.get(user1).add(user2);
            map.get(user2).add(user1);
        }
        return map;
    }


}
