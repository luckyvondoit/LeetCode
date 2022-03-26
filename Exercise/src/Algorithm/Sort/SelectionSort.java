package Algorithm.Sort;

import java.util.Arrays;

public class SelectionSort {
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;

        for (int end = len - 1; end >= 1; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin] > nums[maxIndex]) {
                    maxIndex = begin;
                }
            }

            int tmp = nums[end];
            nums[end] = nums[maxIndex];
            nums[maxIndex] = tmp;
        }

        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,1,4,5};
        int[] nums = {9,8,7,6,5};
        System.out.println(Arrays.toString(SelectionSort.sort(nums)));
    }
}
