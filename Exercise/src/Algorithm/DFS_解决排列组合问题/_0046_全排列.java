package Algorithm.DFS_解决排列组合问题;

import java.util.ArrayList;
import java.util.List;

public class _0046_全排列 {

    private List<List<Integer>> list;
    private int[] nums;
    private List<Integer> selectNums;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        this.nums = nums;
        selectNums = new ArrayList<>();
        dfs(0);
        return list;

    }

    private void dfs(int index) {
        if (index == nums.length) {
            List<Integer> newList = new ArrayList<>();
            for (Integer num : selectNums) {
                newList.add(num);
            }
            list.add(newList);
            return;
        }

        for (int num : nums) {
            if (!selectNums.contains(num)) {
                selectNums.add(index, num);
                dfs(index + 1);
                selectNums.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        _0046_全排列 obj = new _0046_全排列();
        int[] nums = {1, 2, 3};
        System.out.println(obj.permute(nums).toString());
    }
}
