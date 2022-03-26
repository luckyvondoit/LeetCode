package DataStructure.Array;

public class _0088_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0) return;
        if (nums2 == null || nums2.length == 0) return;

        int li = m - 1;
        int ri = n - 1;
        int cur = nums1.length - 1;
        while (ri >= 0) {
            if (li >= 0 && nums1[li] > nums2[ri]) {
                nums1[cur] = nums1[li];
                li--;
            } else {
                nums1[cur] = nums2[ri];
                ri--;
            }
            cur--;
        }
    }
}
