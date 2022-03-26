package Algorithm.Sort;

import java.util.Arrays;

public class BubberSort {
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;

        int sortIndex = 1;
        for (int i = len - 1; i >= 1; i--) {
            System.out.println("current i = " + i);
            for (int j = 1; j<= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    sortIndex = j;
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
            i = sortIndex;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5};
        System.out.println("-------begin--------");
        System.out.println(Arrays.toString(BubberSort.sort(nums)));
        System.out.println("-------end--------");
    }
}
