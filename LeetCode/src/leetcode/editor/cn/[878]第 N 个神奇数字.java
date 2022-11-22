//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
//
// Related Topics 数学 二分查找 👍 157 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        final int MOD = (int) (1e9 + 7);
        int lcm = lcm(a, b);
        if (a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        long l = 0, r = (long) b * n;
        while (l < r - 1) {
            long m = (l + r) >> 1;
            long t = m / a + m / b - m / lcm;
            if (t == n) {
                while (true) {
                    if (m % a == 0 || m % b == 0) {
                        return (int) (m % MOD);
                    }
                    m--;
                }
            }
            if (t > n) {
                r = m;
            } else {
                l = m;
            }
        }
        while (true) {
            if (r % a == 0 || r % b == 0) {
                return (int) (r % MOD);
            }
            r--;
        }
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
