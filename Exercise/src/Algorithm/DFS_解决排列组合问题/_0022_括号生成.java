package Algorithm.DFS_解决排列组合问题;

import java.util.ArrayList;
import java.util.List;
/**
 * 什么情况可以选择左括号？
 * 左括号的数量 > 0
 *
 * 什么情况可以选择有括号？
 * 右括号的数量 > 0 && 左括号的数量 ！= 右括号的数量
 */

public class _0022_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0) return list;
        dfs(0,n,n,list, new char[n << 1]);
        return list;
    }

    /**
     *
     * @param index 层数
     * @param leftRemain 左括号剩余数量
     * @param rightRemain 右括号剩余数量
     * @param list 返回结果
     * @param string 括号字符数组
     */
    private void dfs(int index, int leftRemain, int rightRemain, List<String> list, char[] string) {
        if (index == string.length) {
            list.add(new String(string));
            return;
        }
        if (leftRemain > 0) {
            string[index] = '(';
            dfs(index + 1,leftRemain - 1, rightRemain, list, string);
        }

        if (rightRemain > 0 && leftRemain != rightRemain) {
            string[index] = ')';
            dfs(index + 1, leftRemain, rightRemain - 1, list, string);
        }
    }

    public static void main(String[] args) {
        _0022_括号生成 obj = new _0022_括号生成();
        System.out.println(obj.generateParenthesis(3).toString());
    }
}
