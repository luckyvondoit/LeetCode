package DataStructure.Map;

public class _0036_有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] boxex = new short[9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num == '.') continue;
                num = (char) (1 << (num - '1'));
                if ((rows[row] & num) != 0) return false;
                if ((cols[col] & num) != 0) return false;
                int boxIndex = (row / 3) * 3 + col / 3;
                if ((boxex[boxIndex] & num) != 0) return false;

                rows[row] |= num;
                cols[col] |= num;
                boxex[boxIndex] |= num;
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxex = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num == '.') continue;
                num -= '1';
                if (rows[row][num]) return false;
                if (cols[col][num]) return false;
                int boxIndex = (row / 3) * 3 + col / 3;
                if (boxex[boxIndex][num]) return false;

                rows[row][num] = true;
                cols[col][num] = true;
                boxex[boxIndex][num] = true;

            }
        }
        return true;
    }
}
