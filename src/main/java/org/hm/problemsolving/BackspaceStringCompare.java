package org.hm.problemsolving;

public class BackspaceStringCompare {

    private static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab#c";
        String t1 = "ad#c";
        System.out.println(backspaceCompare(s1, t1));

        String s2 = "ab##";
        String t2 = "c#d#";
        System.out.println(backspaceCompare(s2, t2));

        String s3 = "a#c";
        String t3 = "b";
        System.out.println(backspaceCompare(s3, t3));

        String s4 = "a";
        String t4 = "aa#a";
        System.out.println(backspaceCompare(s4, t4));
    }
}
