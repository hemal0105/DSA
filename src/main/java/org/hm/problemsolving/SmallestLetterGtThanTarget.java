package org.hm.problemsolving;

/**
 * You are given an array of characters letters that is sorted in non-decreasing
 * order, and a character target. There are at least two different characters in letters.
 * Return the smallest character in letters that is lexicographically greater than target.
 * If such a character does not exist, return the first character in letters.
 */
public class SmallestLetterGtThanTarget {
    public static void main(String[] args) {
        char[] letters1 = {'c','f','j'};
        char[] letters2 = {'x','x','y','y'};
        System.out.println(nextGreatestLetter(letters1, 'a'));
        System.out.println(nextGreatestLetter(letters1, 'c'));
        System.out.println(nextGreatestLetter(letters2, 'z'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}
