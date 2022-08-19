package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 0:42
 */
public class Array02 {
    @Test
    public void test628() {
        Random rand = new Random();
        int testTimes = 100;
        for (int t = 0; t < testTimes; t++) {
            int max = rand.nextInt(101);
            int n = rand.nextInt(20) + 3;
            int[] arr = new int[n];
            arr[0] = max;
            for (int i = 1; i < n; i++) {
                arr[i] = rand.nextInt(max + 1000) - 1000;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void test396() {
        int[] arr = new int[]{4, 3, 2, 6};
        System.out.println(maxRotateFunction(arr));
    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                cur += j * nums[(j + n - i) % n];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
