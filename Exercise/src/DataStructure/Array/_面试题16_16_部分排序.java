package DataStructure.Array;


/**
 * 因为array中有重复元素，所以，不能从左边找第一个逆序对，如果接下来的元素相同，m，n之间就不是最小
 * 应该从左向右找最后一个逆序对，
 */
public class _面试题16_16_部分排序 {
    public int[] subSort(int[] array) {
        if (array == null || array.length == 0) return new int[]{-1, -1};
        int m = -1, n = -1;

        int leftMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < leftMax) {
                n = i;
            } else {
                leftMax = array[i];
            }
        }

        if (n == - 1) return new int[]{-1, -1};

        int rightMin = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > rightMin) {
                m = i;
            } else {
                rightMin = array[i];
            }
        }

        return new int[] {m, n};
    }
}
