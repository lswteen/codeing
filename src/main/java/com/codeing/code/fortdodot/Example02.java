package com.codeing.code.fortdodot;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public String[] solution(String[] card, String[] word) {
        List<String> answer = new ArrayList<>();

        for (String targetWord : word) {
            boolean canBeConstructed = true;

            for (int i = 0; i < 3; i++) {
                String cardLine = card[i];
                String target = targetWord;
                for (int j = 0; j < cardLine.length(); j++) {
                    target = target.replaceFirst(Character.toString(cardLine.charAt(j)), "");
                }

                if (i < 2 && target.length() > 0) {
                    canBeConstructed = false;
                    break;
                }
            }

            if (canBeConstructed && targetWord.length() == 0) {
                answer.add(targetWord);
            }
        }

        if (answer.isEmpty()) {
            answer.add("-1");
        }

        return answer.toArray(new String[0]);
    }



    public String[] solution1(String[] card, String[] word) {
        int[][] count = new int[3][26]; // 각 줄에서 사용 가능한 알파벳의 개수
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                char c = card[i].charAt(j);
                count[i][c - 'A']++; // 해당 알파벳의 개수 증가
            }
        }
        String[] answer = new String[word.length];
        for (int i = 0; i < word.length; i++) {
            int[] needs = new int[26]; // 필요한 알파벳의 개수
            for (int j = 0; j < word[i].length(); j++) {
                char c = word[i].charAt(j);
                needs[c - 'A']++; // 해당 알파벳의 필요한 개수 증가
            }
            boolean canMake = true;
            for (int j = 0; j < 26; j++) {
                if (needs[j] > count[0][j] + count[1][j] + count[2][j]) {
                    canMake = false; // 필요한 알파벳의 개수보다 사용 가능한 개수가 적으면 만들 수 없음
                    break;
                }
            }
            if (canMake) {
                answer[i] = word[i];
            } else {
                answer[i] = "-1";
            }
        }
        return answer;
    }

    public String[] solution4(String[] card, String[]word){
        Set<Character> characterSet = new LinkedHashSet<>();

        // 중복을 제거하지 않은 문자열 집합 생성
        for (String cardItem : card) {
            for (char c : cardItem.toCharArray()) {
                characterSet.add(c);
            }
        }

        // 각각의 word 문자열을 확인하며 조합 가능한지 확인
        ArrayList<String> answerList = new ArrayList<>();
        for (String wordItem : word) {
            boolean canMakeWord = true;
            for (char c : wordItem.toCharArray()) {
                if (!characterSet.contains(c)) {
                    canMakeWord = false;
                    break;
                }
            }
            if (canMakeWord) {
                answerList.add(wordItem);
            }
        }

        // 결과 출력
        System.out.println("조합 가능한 문자열:");
        for (String ans : answerList) {
            System.out.println(ans);
        }
        return answerList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Example02 solution = new Example02();
        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLMKM"};
        String[] word = {"GPQM", "GPMZ", "EFU", "MMNA"};

//        String[] card = {"AABBCCDD", "KKKKJJJJ", "MOMOMOMO"};
//        String[] word = {"AAAKKKKKMMMMM", "ABCDKJ"};

        String[] result = solution.solution4(card, word);
        System.out.println(Arrays.toString(result)); // 기대 출력: [GPQM, MMNA]
    }
}
