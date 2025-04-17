package org.hm.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Factors {

    // O(n)
    private static List<Integer> factors(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                res.add(i);
            }
        }
        res.add(n);

        return res;
    }

    private static Set<Integer> factorsImproved(int n) {
        Set<Integer> res = new TreeSet<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != Math.sqrt(n)) {
                    res.add(n/i);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(factors(12));
        System.out.println(factors(17));
        System.out.println(factors(36));

        System.out.println();
        System.out.println(factorsImproved(12));
        System.out.println(factorsImproved(17));
        System.out.println(factorsImproved(36));
    }

}
