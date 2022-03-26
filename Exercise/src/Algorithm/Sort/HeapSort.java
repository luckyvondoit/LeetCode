package Algorithm.Sort;

import java.util.Arrays;

public class HeapSort {

    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            shitDown(i, nums, len);
        }

        while (len > 1) {
            int tmp = nums[0];
            nums[0] = nums[len - 1];
            nums[len - 1] = tmp;

            len--;

            shitDown(0, nums, len);
        }
        return nums;

    }

    private static void shitDown(int index, int[] nums, int size) {
        int len = size;
        int tmp = nums[index];

        while (index < len / 2) {
            int childIndex = index * 2 + 1;
            int child = nums[childIndex];
            if (childIndex + 1 < len && nums[childIndex + 1] > child) {
                child = nums[childIndex + 1];
                childIndex = childIndex + 1;
            }

            if (child <= tmp) break;

            nums[index] = child;
            index = childIndex;
        }

        nums[index] = tmp;

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5};
//        int[] nums = {1,2,3,4,6};
        System.out.println(Arrays.toString(HeapSort.sort(nums)));
    }

}
