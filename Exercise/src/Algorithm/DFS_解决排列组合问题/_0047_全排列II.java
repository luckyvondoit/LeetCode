package Algorithm.DFS_解决排列组合问题;

import java.util.ArrayList;
import java.util.List;

public class _0047_全排列II {

    private int[] nums;
    List<List<Integer>> list;

    public List<List<Integer>> permuteUnique(int[] nums) {
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
            //保证一个数字在index处只出现一次。
            if (isRepeat(index, i)) continue;
            swap(index, i);
            dfs(index + 1);
            swap(index, i);

        }
    }

    private boolean isRepeat(int index, int position) {
        for (int i = index; i < position; i++) {
            if (nums[position] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
 }
