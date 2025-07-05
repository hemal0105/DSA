package org.hm.interviews;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //[[eat, tea, ate], [tan, nat], [bat]]
        groupAna(input);
    }

    // key , value

    // b1 -> k1, k3
    // b2 -> k2


    // m1 -> key1


    // p1 - key1, | Key1, ()
    // p2
    // p3



    public static void groupAna(String[] input) {
        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            char[] charStr = input[i].toCharArray();
            Arrays.sort(charStr);
            String sortedStr = String.valueOf(charStr);

            //result.computeIfAbsent(sortedStr, (sortedStr) -> new ArrayList<>());


            result.putIfAbsent(sortedStr, new ArrayList<>());
            result.get(sortedStr).add(input[i]);


            /*
            if (result.containsKey(sortedStr)) {
                result.get(sortedStr).add(input[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(input[i]);
                result.put(sortedStr, list);
            }*/
        }

        System.out.println(result.values());
    }
}
