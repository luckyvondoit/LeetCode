package Algorithm.Sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        sort(0, nums.length, nums);
        return nums;
    }

    private static void sort(int begin, int end, int[] nums) {
        if (end - begin < 2) return;

        int mid = (begin + end) / 2 ;
        sort(begin, mid, nums);
        sort(mid, end, nums);
        merge(begin, mid, end, nums);

    }

    private static void merge(int begin, int mid, int end, int[] nums) {
        int lb = 0;
        int le = mid - begin;
        int rb = mid;
        int re = end;
        int index = begin;

        int[] leftArray = new int[mid - begin];
        for (int i = begin; i < mid; i++) {
            leftArray[i - begin] = nums[i];
        }

        while (lb < le) {
            if (rb < re && nums[rb] < leftArray[lb]) {
                nums[index++] = nums[rb++];
            } else {
                nums[index++] = leftArray[lb++];
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5};
        System.out.println(Arrays.toString(MergeSort.sort(nums)));
    }

}
