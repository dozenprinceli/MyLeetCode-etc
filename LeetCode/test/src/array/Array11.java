package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/9/20 0:35
 */
public class Array11 {
    @Test
    public void test698() {
        int[] nums = new int[]{4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9};
        int k = 5;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int size = sum / k;
        if (sum % k != 0 || nums[n - 1] > size) {
            return false;
        }
        boolean[] occupied = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            if (occupied[i]) {
                continue;
            }
            occupied[i] = true;
            if (!dfs(nums, occupied, size - nums[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] nums, boolean[] occupied, int residue) {
        if (residue == 0) {
            return true;
        }
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (occupied[i] || nums[i] > residue) {
                continue;
            }
            if (nums[i] == residue) {
                occupied[i] = true;
                return true;
            } else if (nums[i] < residue) {
                occupied[i] = true;
                if (dfs(nums, occupied, residue - nums[i])) {
                    return true;
                } else {
                    occupied[i] = false;
                }
            }
        }
        return false;
    }
}
