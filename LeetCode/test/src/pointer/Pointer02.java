package pointer;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2023/8/13 15:10
 */
public class Pointer02 {
    @Test
    public void test80() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = start + 1;
        int removeLen = 0;
        while (end < nums.length - removeLen) {
            if (nums[start] != nums[end]) {
                start = end;
                end = start + 1;
                continue;
            }
            while (end < nums.length - removeLen && nums[start] == nums[end]) {
                end++;
            }
            if (end - start > 2) {
                System.arraycopy(nums, end, nums, start + 2, nums.length - end);
                removeLen += end - start - 2;
            }
            start += 2;
            end = start + 1;
        }
        return nums.length - removeLen;
    }
}
