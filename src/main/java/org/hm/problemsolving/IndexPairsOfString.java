package org.hm.problemsolving;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a string text and an array of strings words,
 * return an array of all index pairs [i, j] so that the substring text[i...j] is in words.
 * Return the pairs [i, j] in sorted order (i.e., sort them by their first coordinate,
 * and in case of ties sort them by their second coordinate).
 */
public class IndexPairsOfString {
    private static int[][] indexPairs(String text, String[] words) {
        Set<String> setWords = Arrays.stream(words).collect(Collectors.toSet());
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                if (setWords.contains(text.substring(i, j+1))) {
                    result.add(new int[] {i, j});
                }
            }
        }
        int[][] resArr = new int[result.size()][];
        resArr = result.toArray(resArr);
        return resArr;
    }

    public static void main(String[] args) {
        String text1 = "thestoryofleetcodeandme";
        String[] words1 = {"story", "fleet", "leetcode"};
        System.out.println(Arrays.deepToString(indexPairs(text1, words1)));

        String text2 = "ababa";
        String[] words2 = {"aba", "ab"};
        System.out.println(Arrays.deepToString(indexPairs(text2, words2)));
    }
}
