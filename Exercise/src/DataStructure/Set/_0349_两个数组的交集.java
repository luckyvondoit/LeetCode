package DataStructure.Set;

import java.util.*;

public class _0349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 ) return new int[0];
        if (nums2 == null || nums2.length == 0 ) return new int[0];

        Set<Integer> s1 = new HashSet<>();
        for (int num: nums1) {
            s1.add(num);
        }

        Set<Integer> s2 = new HashSet<>();
        for (int num: nums2) {
            s2.add(num);
        }

        if (s1.size() > s2.size()) {
            Set<Integer> tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        List<Integer> list = new LinkedList<>();

        for (int num: s1) {
            if (s2.contains(num)) {
                list.add(num);
            }
        }

        int len = list.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
