package math;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/9/26 13:13
 */
public class Math06 {
    @Test
    public void test17_19() {
        int[] nums = new int[]{3};
        System.out.println(Arrays.toString(missingTwo(nums)));
    }

    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = n * (n + 1) / 2 - Arrays.stream(nums).sum();
        int squareSum = n * (n + 1) * (2 * n + 1) / 6;
        for (int num : nums) {
            squareSum -= num;
        }
        int sqrt = (int) Math.round(Math.sqrt(2 * squareSum - sum * sum));
        return new int[]{(sum + sqrt) / 2, (sum - sqrt) / 2};
    }
}
