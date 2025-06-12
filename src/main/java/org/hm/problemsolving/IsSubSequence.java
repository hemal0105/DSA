package org.hm.problemsolving;

public class IsSubSequence {
    private String source;
    private String target;

    private Integer sourceLen;
    private Integer targetLen;

    private boolean isSubsequenceRec(int srcIdx, int tgtIdx) {
        if (srcIdx == sourceLen) return true;
        if (tgtIdx == targetLen) return false;

        if (source.charAt(srcIdx) == target.charAt(tgtIdx)) srcIdx++;
        tgtIdx++;

        return isSubsequenceRec(srcIdx, tgtIdx);
    }


    private boolean isSubsequence(String source, String target) {
        this.source = source;
        this.target = target;

        this.sourceLen = source.length();
        this.targetLen = target.length();

        return isSubsequenceRec(0, 0);
    }

    public static void main(String[] args) {
        IsSubSequence isSubSequenceObj = new IsSubSequence();
        System.out.println(isSubSequenceObj.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubSequenceObj.isSubsequence("axc", "ahbgdc"));
    }
}
