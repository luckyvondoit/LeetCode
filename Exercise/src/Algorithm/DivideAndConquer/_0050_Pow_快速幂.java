package Algorithm.DivideAndConquer;

/**
 * 2^21 将21转换成二进制的到2^(10101)
 * = 2^(1*2^4 + 0*2^3 + 1*2^2 + 0*2^1 + 1*2^0)
 * = 2^(1*2^4) * 2^(0*2^3) * 2^(1*2^2) * 2^(0*2^1) * 2^(1*2^0)
 * = 2^(2^4) * 1 * 2^(2^2) * 1 * 2^(2^0)
 *
 * 2^(2^1) = 2^(2^0) * 2^(2^0)
 * 2^(2^2) = 2^(2^1) * 2^(2^1)
 * ...
 *
 * 思路：
 *
 */

public class _0050_Pow_快速幂 {
    /**
     * 7 >> 1 = 3
     * -7 >> 1 = -4
     *
     * 2^6 = 2^3 * 2^3
     * 2^7 = 2^3 * 2^3 * 2
     *
     * 2^(-6) = 2^(-3) * 2^(-3)
     * 2^(-7) = 2^(-4) * 2^(-4) * 2
     */
    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double half = myPow1(x,n >> 1);
        half *= half;
        //无需判断n是否为负数
        return (n & 1) == 1 ? half * x : half;

    }

    public double myPow(double x, int n) {
        boolean neg = n < 0;
        long y = neg ? -((long) n) : n;
        double res = 1.0;
        while ( y > 0) {
            // n的二进制位为0时，结果为1不需要乘。
            if (( y & 1) == 1) {
                res *= x;
            }

            x *= x;
            // ((n >> 1) & 1)可以从低到高判断n的二进制的每一位
            y >>= 1;
        }
        return neg ? (1 / res) : res;
    }

    /** 快速幂补充：求(x^y)%z
     * x,y,z都很大
     * y>=0,z!=0
     * x^y可能溢出，不能直接求
     *
     * 公式须知
     * (a * b) % p == ((a % p) * (b % p)) % p
     */

    public double myPow2(int x, int y, int z) {
        if (x < 0 || y < 0 || z == 0) return 0;
        int res = 1 % z;
        x %= z;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % z;
            }
            x = (x * x) % z;
            y >>= 1;
        }
        return res % z;
    }
}
