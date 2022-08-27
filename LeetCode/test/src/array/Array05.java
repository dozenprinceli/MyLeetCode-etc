package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/8/28 1:08
 */
public class Array05 {
    @Test
    public void output5Times() {
        int i = 1;
        int[] arr5 = new int[15];
        int curNum = 1;
        while (i < 15) {
            arr5[i] = curNum + arr5[i - 1];
            curNum *= 5;
            i++;
        }
        System.out.println(Arrays.toString(arr5));
    }

    @Test
    public void testGetZeros() {
        int num = 150;
        System.out.println(getZeros(num));
    }

    private int getZeros(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num / 5;
            num /= 5;
        }
        return ans;
    }
}
