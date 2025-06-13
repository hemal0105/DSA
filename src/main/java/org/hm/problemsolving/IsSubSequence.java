package org.hm.problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubSequence {
    private String source;
    private String target;

    private Integer sourceLen;
    private Integer targetLen;

    private boolean isSubsequenceRecUtil(int srcIdx, int tgtIdx) {
        if (srcIdx == sourceLen) return true;
        if (tgtIdx == targetLen) return false;

        if (source.charAt(srcIdx) == target.charAt(tgtIdx)) srcIdx++;
        tgtIdx++;

        return isSubsequenceRecUtil(srcIdx, tgtIdx);
    }


    private boolean isSubsequenceRec(String source, String target) {
        this.source = source;
        this.target = target;

        this.sourceLen = source.length();
        this.targetLen = target.length();

        return isSubsequenceRecUtil(0, 0);
    }

    private boolean isSubsequenceItr(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();

        int srcIdx = 0, tgtIdx = 0;
        while (srcIdx < sourceLen && tgtIdx < targetLen) {
            if (source.charAt(srcIdx) == target.charAt(tgtIdx)) srcIdx++;
            tgtIdx++;
        }
        return srcIdx == sourceLen;
    }

    private boolean isSubsequenceWithMap(String source, String target) {
        Map<Character, List<Integer>> targetIndicesMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            if (targetIndicesMap.containsKey(target.charAt(i))) {
                targetIndicesMap.get(target.charAt(i)).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                targetIndicesMap.put(target.charAt(i), indices);
            }
        }

        int matchIndex = -1;
        for (char letter: source.toCharArray()) {
            if (!targetIndicesMap.containsKey(letter)) return false;

            boolean isMatched = false;
            for (Integer targetIndex : targetIndicesMap.get(letter)) {
                if (matchIndex < targetIndex) {
                    matchIndex = targetIndex;
                    isMatched = true;
                    break;
                }
            }

            if (!isMatched) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubSequence isSubSequenceObj = new IsSubSequence();
        System.out.println(isSubSequenceObj.isSubsequenceRec("abc", "ahbgdc"));
        System.out.println(isSubSequenceObj.isSubsequenceRec("axc", "ahbgdcd"));

        System.out.println(isSubSequenceObj.isSubsequenceItr("abc", "ahbgdc"));
        System.out.println(isSubSequenceObj.isSubsequenceItr("axc", "ahbgdcd"));

        System.out.println(isSubSequenceObj.isSubsequenceWithMap("abc", "ahbgdc"));
        System.out.println(isSubSequenceObj.isSubsequenceWithMap("axc", "ahbgdcd"));
    }
}
