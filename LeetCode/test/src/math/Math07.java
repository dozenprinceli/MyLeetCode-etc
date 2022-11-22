package math;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/11/22 21:53
 */
public class Math07 {
    @Test
    public void test878() {
        int n = 8, a = 8, b = 8;
        System.out.println(nthMagicalNumber(n, a, b));
    }

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
