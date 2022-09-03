package math;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/9/4 3:04
 */
public class Math04 {
    @Test
    public void test400() {
        int n = 1000000000;
        System.out.println(findNthDigit(n));
    }

    public int findNthDigit(int n) {
        if (n < 9) {
            return n;
        }
        long prevCnt = 0;
        int digit = 0;
        while (true) {
            int cur = 9 * (int) Math.pow(10, digit) * (digit + 1);
            prevCnt += cur;
            digit++;
            if (prevCnt >= n) {
                prevCnt -= cur;
                break;
            }
        }
        int move = n - (int) prevCnt;
        int idx = move / digit;
        if (move % digit == 0) {
            return ((int) Math.pow(10, digit - 1) + idx - 1) % 10;
        } else {
            int num = (int) Math.pow(10, digit - 1) + idx;
            return Integer.parseInt(String.valueOf(String.valueOf(num).charAt(move % digit - 1)));
        }
    }
}
