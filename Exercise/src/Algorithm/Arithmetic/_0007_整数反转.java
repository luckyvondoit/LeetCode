package Algorithm.Arithmetic;

public class _0007_整数反转 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int prevRes = res;
            res = prevRes * 10 + x % 10;
            /** 判断是否越界 */
            if ((res - x % 10) / 10 != prevRes) return 0;
            x = x / 10;
        }
        return res;
    }
}
