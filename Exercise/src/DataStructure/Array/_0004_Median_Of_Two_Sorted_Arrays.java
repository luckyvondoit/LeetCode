package DataStructure.Array;

public class _0004_Median_Of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        int len1 = nums1.length;
        int len2 = nums2.length;

        boolean isOdd = (len1 + len2) % 2 != 0;
        int midIdx = (len1 + len2) / 2;

        int il = 0, ir = 0, idx = 0;
        int current = 0,prev = 0;

        while (il < len1 || ir < len2) {
            if (idx != 0) {
                prev = current;
            }
            if (il < len1 && ir < len2) {
                int n1 = nums1[il];
                int n2 = nums2[ir];
                if (n1 <= n2) {
                    current = nums1[il];
                    il++;

                } else {
                    current = nums2[ir];
                    ir++;
                }
            } else if (il < len1 && ir >= len2) {
                current = nums1[il];
                il++;
            } else if (il >= len1 && ir < len2) {
                current = nums2[ir];
                ir++;
            }

            if (idx == midIdx) {
                if (isOdd) {
                    return current;
                } else {
                    return (prev + current) / 2.0;
                }
            }

            idx++;

        }


        return 0;
    }
}
