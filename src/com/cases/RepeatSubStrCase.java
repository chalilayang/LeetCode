package com.cases;

import java.util.HashMap;
import java.util.Map;

public class RepeatSubStrCase {
    public static void main(String[] args) {
        System.out.println(getMaxLength("abcdefg"));
    }

    private static int getMaxLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        Map<Character, Integer> set = new HashMap<>();
        int count = chars.length;
        int start = 0;
        int end = 1;

        int maxStart = 0;
        int maxEnd = 1;
        set.put(chars[maxStart], maxStart);
        while(start < count && end <= count-1 && start < end) {
            if (!set.containsKey(chars[end])) {
                set.put(chars[end], end);
                end ++;
            } else {
                int pos = set.get(chars[end]);
                for (int index = start; index <= pos; index ++) {
                    set.remove(chars[index]);
                }
                set.put(chars[end], end);
                int curMax = end - start;
                int max = maxEnd - maxStart;
                if (curMax > max) {
                    maxStart = start;
                    maxEnd = end;
                }
                start = pos+1;
                end ++;
            }
        }
//        if (set.size() > (maxEnd - maxStart)) {
//            Iterator<Integer> integers = set.values().iterator();
//            int min = count;
//            int max = -1;
//            while(integers.hasNext()) {
//                int value = integers.next();
//                if (value < min) {
//                    min = value;
//                }
//                if (value > max) {
//                    max = value;
//                }
//            }
//            System.out.println(str.substring(min, max+1));
//        } else {
//            System.out.println(str.substring(maxStart, maxEnd));
//        }
        return Math.max(maxEnd - maxStart, set.size());
    }
}
