/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
package DataStructure.Array;

import java.util.*;

public class _0350_两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        int[] arr1, arr2;
        if (nums1.length < nums2.length) {
            arr1 = nums1;
            arr2 = nums2;
        } else  {
            arr1 = nums2;
            arr2 = nums1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[arr2.length];

        int index = 0;
        for (int num : arr2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                result[index++] = num;
                map.put(num, --count);
            }
        }

        return Arrays.copyOfRange(result,0, index);
    }
}
