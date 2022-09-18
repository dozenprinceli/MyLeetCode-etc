package biweekly.c87;

import org.junit.Test;

import java.util.Arrays;

/**
 * TODO TLE
 * @author Dozen Lee<br/>
 * 2022/9/17 22:29
 */
public class C {
    public int[] smallestSubarrays(int[] nums) {
        int[] ans = new int[nums.length];
        int[] binaryFreq = new int[31];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                ans[i] = 1;
                String bin = Integer.toBinaryString(nums[i]);
                for (int j = 0; j < bin.length(); j++) {
                    if (bin.charAt(bin.length() - j - 1) == '1') {
                        binaryFreq[30 - j]++;
                    }
                }
                continue;
            }

            String curBin = Integer.toBinaryString(nums[i]);
            for (int k = 0; k < curBin.length(); k++) {
                if (curBin.charAt(curBin.length() - k - 1) == '1') {
                    binaryFreq[30 - k]++;
                }
            }

            int curMaxLen = ans[i + 1];
            for (int j = i + curMaxLen; j >= i; j--) {
                String bin = Integer.toBinaryString(nums[j]);
                boolean isEnd = false;
                for (int k = 0; k < bin.length(); k++) {
                    if (bin.charAt(bin.length() - k - 1) == '1' && binaryFreq[30 - k] == 1) {
                        ans[i] = j - i + 1;
                        isEnd = true;
                        break;
                    }
                }
                if (isEnd) {
                    break;
                }
                for (int k = 0; k < bin.length(); k++) {
                    if (bin.charAt(bin.length() - k - 1) == '1') {
                        binaryFreq[30 - k]--;
                    }
                }
            }
            for (int j = 0; j < ans.length; j++) {
                if (ans[j] == 0) {
                    ans[j] = 1;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] test = new int[]{1, 0, 0, 0};
        System.out.println(Arrays.toString(smallestSubarrays(test)));
    }
}
