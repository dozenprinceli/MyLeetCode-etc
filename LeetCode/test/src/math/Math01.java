package math;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/28 14:26
 */
public class Math01 {
    @Test
    public void test793() {
        int k = 25;
        System.out.println(preimageSizeFZF(k));
    }

    public int preimageSizeFZF(int k) {
        if (k == 0) {
            return 5;
        }
        long left = 4L * k;
        long right = 5L * k;
        while (right > left) {
            int curZero = getZeros(right);
            long next = right - 3L * (curZero - k);
            if (curZero == k) {
                return 5;
            } else if (curZero < k) {
                break;
            } else {
                right = next;
            }
        }
        return 0;
    }

    private int getZeros(long num) {
        int ans = 0;
        while (num != 0) {
            ans += num / 5;
            num /= 5;
        }
        return ans;
    }
}
