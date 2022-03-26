package Algorithm.Sort;

import java.util.Arrays;

public class InsertSort {
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            int curIndex = i;
            while (curIndex >0 && cur < nums[curIndex - 1]) {
                nums[curIndex] = nums[curIndex - 1];
                curIndex--;
            }
            nums[curIndex] = cur;
        }
        return nums;
    }

    public static int[] sort1(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int tmp = nums[i];
            int index = index(0, i, nums, tmp);
            for (int j = i; j > index; j--) {
                nums[j] = nums[j - 1];
            }
            nums[index] = tmp;
        }
        return nums;
    }

    private static int index(int begin, int end, int[] nums, int num) {
        if (begin >= end) return -1;

        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] < num) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }


    public static void main(String[] args) {
//        int[] nums = {3,2,1,4,5};
//        System.out.println(Arrays.toString(InsertSort.sort(nums)));

        int[] nums = {3,1,1,4,5};
        System.out.println(Arrays.toString(InsertSort.sort1(nums)));
    }
}
