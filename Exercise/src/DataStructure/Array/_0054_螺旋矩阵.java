package DataStructure.Array;

import java.util.ArrayList;
import java.util.List;

public class _0054_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return list;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;

            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
