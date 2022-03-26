package Algorithm.DFS_解决排列组合问题;

import java.util.ArrayList;
import java.util.List;

public class _0046_全排列1 {
    private List<List<Integer>> list;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        dfs(0);
        return list;
    }

    private void dfs(int index) {
        if (index == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums) {
                result.add(num);
            }
            list.add(result);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i);
            dfs(index + 1);
            swap(index, i);
        }
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
