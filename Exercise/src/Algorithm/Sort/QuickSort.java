package Algorithm.Sort;

public class QuickSort {
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        sort(0, nums.length, nums);
        return nums;
    }

    private static void sort(int begin, int end, int[] nums) {
        if (end - begin < 2) return;
        int anchorIndex = anchorIndex(begin, end, nums);
        sort(begin, anchorIndex, nums);
        sort(anchorIndex + 1, end, nums);
    }

    private static int anchorIndex(int begin, int end, int[] nums) {
        int randomIndex =(int) (begin + Math.random() * (end - begin));

        int element = nums[randomIndex];
        nums[randomIndex] = nums[begin];
        nums[begin] = element;


        end--;
        while (begin < end) {
            while (begin < end) {
                if (nums[end] > element) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }
            while (begin < end) {
                if (nums[begin] < element) {
                    begin++;
                } else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        nums[begin] = element;
        return begin;
    }


    public static void main(String[] args) {

    }
}
