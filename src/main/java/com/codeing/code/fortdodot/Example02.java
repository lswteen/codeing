package com.codeing.code.fortdodot;

import java.util.*;

/**
 *
 * 알파벳이 적힌 카드 24장이 한줄에 8장씩 세줄 놓여있다.
 * 같은 알파벳이 적힌 카드가 여러장 있을수 있으나, 같은 알바뱃이 적힌 카드는 반드시 같은 줄에 놓여 있다
 *
 * 예를들어
 * A B A C D E F G
 * N O P Q R S T U
 * H I J K L K M M
 *
 * 어떤 단어들이 주어질때 각던어를 주어진 카드로 만들수 있는지 판별 하려고 한다.
 * 단 주어진 카드로 만들때는 반드시 한줄에 한카드는 사용해야한다.
 *
 * 예를들어 주어진단어가
 * ["GPQM", "GPMZ", "EFU", "MMNA"] 인 경우
 *
 * "GPQM" 이라는 단어는
 * A B A C D E F G
 * N O P Q R S T U
 * H I J K L K M M
 *
 * 첫번째 줄에서 G
 * 두번째 줄에서 P와Q
 * 세번째 줄에서 M
 * 을골라 만들수 있다.
 *
 * GPMZ 단어는
 * Z가 적힌카드가 없으므로 만들수없다.
 *
 * EFU 단어는
 * 첫번쨰 E,F
 * 두번째 U
 * 세번째 줄에서 카드를 사용하지 않았기때문에 단어를 만들수 없다.
 *
 * MMNA단어는
 * 첫번째 A, 두번째 N, 세번째 ,M2개 만들수 있다.
 *
 * 알파벳이 적힌 카드 card 와 만들어야 하는단어들 word 가 매개변수로 주어질때 만들수 있는 단어들 return 하는 solution 함수 완성
 *
 * 단만드수 있는 단어들을 return 매개변수 word 순서대로 반환
 *
 * 못만들면 1차원배열 -1반환
 *
 * class Solution {
 *     public String[] solution(String[] card, String[] word) {
 *         String[] answer = {};
 *         return answer;
 *     }
 * }
 *
 * 제한사항
 * card 길이가 3인 1차원 배열입니다.
 * card의 원소 길이는 8 string 형입니다. 이문자열은 대문자로만 이루어져있습니다.
 * word는 1차원 배열로 주어지며 배열 길이는 10이하 자연수 입니다.
 * word 각원소 string형이며 각원소의 길이는 24이하의 자연수입니다.* *
 * * * *
 */
public class Example02 {
//    public static String[] solution(String[] card, String[] word) {
//        //card 배열 3개를 모두 loop로 돌린다.
//
//        //word 문자열배열 순환 루프한다. card 3개 배열에 모두포함하는지 확인한다
//        //word에 문자열이 card 배열에 index1, index2 ,index3 에 모두포함되어있는지 확인한다.
//        //word에 문자열이 card배열 조건에 부합한다면
//        //answer String[] 추가한다.
//        //포함되어있지 않다면 -1로 추가한다.
//
//
//
//        return null;
//    }


    public static String[] solution(String[] card, String[] word) {
        ArrayList<String> answerList = new ArrayList<>();
        boolean hasFailed = false;
        boolean hasSucceeded = false;

        for (String w : word) {
            if (isWordInCards(card, w)) {
                answerList.add(w);
                hasSucceeded = true;
            } else {
                hasFailed = true;
            }
        }

        if (!hasSucceeded && hasFailed) {
            answerList.add("-1");
        }

        String[] answer = new String[answerList.size()];
        answerList.toArray(answer);
        return answer;
    }

//    private static boolean isWordInCards(String[] card, String word) {
//        int[] cardCount = new int[26];
//        int[] wordCount = new int[26];
//        boolean[] cardUsed = new boolean[3];
//
//        for (char ch : word.toCharArray()) {
//            wordCount[ch - 'A']++;
//        }
//
//        for (int i = 0; i < card.length; i++) {
//            String c = card[i];
//            for (char ch : c.toCharArray()) {
//                cardCount[ch - 'A']++;
//            }
//
//            for (int j = 0; j < 26; j++) {
//                if (wordCount[j] > 0 && cardCount[j] > 0) {
//                    int minCount = Math.min(wordCount[j], cardCount[j]);
//                    wordCount[j] -= minCount;
//                    cardCount[j] -= minCount;
//                    cardUsed[i] = true;
//                }
//            }
//        }
//
//        for (int count : wordCount) {
//            if (count > 0) {
//                return false;
//            }
//        }
//
//        for (boolean used : cardUsed) {
//            if (!used) {
//                return false;
//            }
//        }
//
//        return true;
//    }


    private static boolean isWordInCards(String[] card, String word) {
        Map<Character, Integer> cardCount = new HashMap<>();
        Map<Character, Integer> wordCount = new HashMap<>();
        boolean[] cardUsed = new boolean[3];

        for (char ch : word.toCharArray()) {
            wordCount.put(ch, wordCount.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < card.length; i++) {
            String c = card[i];
            for (char ch : c.toCharArray()) {
                cardCount.put(ch, cardCount.getOrDefault(ch, 0) + 1);
            }

            for (char ch : wordCount.keySet()) {
                if (wordCount.get(ch) > 0 && cardCount.getOrDefault(ch, 0) > 0) {
                    int minCount = Math.min(wordCount.get(ch), cardCount.get(ch));
                    wordCount.put(ch, wordCount.get(ch) - minCount);
                    cardCount.put(ch, cardCount.get(ch) - minCount);
                    cardUsed[i] = true;
                }
            }
        }

        for (int count : wordCount.values()) {
            if (count > 0) {
                return false;
            }
        }

        for (boolean used : cardUsed) {
            if (!used) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Example02 solution = new Example02();
        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLMKM"};
        String[] word = {"GPQM", "GPMZ", "EFU", "MMNA", "AASH", "AAANH"};

//        String[] card = {"AABBCCDD", "KKKKJJJJ", "MOMOMOMO"};
//        String[] word = {"AAAKKKKKMMMMM", "ABCDKJ"};

        String[] result = solution.solution(card, word);
        System.out.println(Arrays.toString(result)); // 기대 출력: [GPQM, MMNA]
    }
}
