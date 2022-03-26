package DataStructure.Array;

// 数组只有三种颜色分别用0，1，2表示，进行排序，时间复杂度为O(n);
public class _0075_颜色分类 {

    /** 根据cur处的值进行处理
     * 遇到0，swap(li,cur),li++,cur++
     * 遇到1， cur++
     * 遇到2，swap(ri, cur), ri--, 再次对cur处进行处理。
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int li = 0;
        int ri = nums.length - 1;
        int cur = 0;
        while (cur <= ri) {
            int num = nums[cur];
            if (num == 0) {
                swap(nums, cur++, li++);
            } else if (num == 1) {
                cur++;
            } else {
                swap(nums, cur, ri--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
