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

    private static int[][] indexPairsTrie(String text, String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            TrieNode p = trie.root;
            for (int j = i; j < text.length(); j++) {
                if (p.next.get(text.charAt(j)) == null) {
                    break;
                }
                p = p.next.get(text.charAt(j));
                if (p.flag) {
                    result.add(new int[] {i, j});
                }
            }
        }
        int[][] ans = new int[result.size()][];
        ans = result.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        String text1 = "thestoryofleetcodeandme";
        String[] words1 = {"story", "fleet", "leetcode"};
        System.out.println(Arrays.deepToString(indexPairs(text1, words1)));
        System.out.println(Arrays.deepToString(indexPairsTrie(text1, words1)));

        String text2 = "ababa";
        String[] words2 = {"aba", "ab"};
        System.out.println(Arrays.deepToString(indexPairs(text2, words2)));
        System.out.println(Arrays.deepToString(indexPairsTrie(text2, words2)));
    }
}

class TrieNode {
    public boolean flag;
    public Map<Character, TrieNode> next = new HashMap<>();
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null) {
                curr.next.put(c, new TrieNode());
            }
            curr = curr.next.get(c);
        }
        curr.flag = true;
    }
}
