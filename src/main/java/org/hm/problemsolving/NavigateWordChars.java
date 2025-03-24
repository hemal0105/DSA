package org.hm.problemsolving;

import java.util.ArrayList;
import java.util.List;

/* Given an alphabet, a display width, and a word; assume a keyboard is
 * shown on a screen and the word given must be spelled by navigating the on
 * screen keyboard using an 'up', 'left', 'down', 'right' command structure.
 *
 * For Example, the alphabet [a-z] and a width of 5 would produce the
 * following keyboard:
 *
 * a b c d e
 * f g h i j
 * k l m n o
 * p q r s t
 * u v w x y
 * z
 *
 * Using the navigation:
 *
 *   &uarr;
 * &larr; * &rarr;
 *   &darr;
 *
 * 'dog' would produce '3R*2D1R*3L1U*'
 *
 * [initial] -> 'd' == 3 right moves, and 'enter'                (3R*)
 * 'd' -> 'o' == 1 right move, two down moves, and 'enter' (2D1R*)
 * 'o' -> 'g' == 3 left moves, one up move, and 'enter'    (3L1U*)
 *
 * 'abc' would produce '*1R*1R*'
 *
 * [initial] -> 'a' == 'enter' (*)
 * 'a' -> 'b' == 1 right move, and 'enter' (1R*)
 * 'b' -> 'c' == 1 right move, and 'enter' (1R*)
 */
public class NavigateWordChars {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y =y;
        }
    }
    public static void main(String[] args) {
        List<Pair> coordinates = new ArrayList<>();
        coordinates.add(new Pair(0, 0));
        char start = 'a';
        int width = 5;
        String word = "dog";
        
        for (char c : word.toCharArray()) {
            int dist = c - start;
            int row = dist / width;
            int col = dist % width;
            coordinates.add(new Pair(row, col));

        }

        System.out.println(coordinates);

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < coordinates.size() - 1; i++) {
            Pair coor1 = coordinates.get(i);
            Pair coor2 = coordinates.get(i+1);
            int vertical = coor2.x - coor1.x;

            if (vertical > 0) {
                res.append(vertical+"D");
            } else {
                res.append(vertical*-1+"U");
            }

            int horz = coor2.y - coor1.y;

            if (horz > 0) {
                res.append(horz+"R");
            } else {
                res.append(horz*-1+"L");
            }
            res.append("*");
        }
        System.out.println(res.toString());
    }
}
