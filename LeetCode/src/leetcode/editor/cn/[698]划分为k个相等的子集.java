//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 661 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int size = sum / k;
        if (sum % k != 0 || nums[n - 1] > size) {
            return false;
        }
        int[] groups = new int[k];
        return dfs(nums, n - 1, groups, k, size);
    }

    private boolean dfs(int[] nums, int idx, int[] groups, int k, int size) {
        if (idx == -1) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (i > 0 && groups[i - 1] == groups[i]) {
                continue;
            }
            if (groups[i] + nums[idx] > size) {
                continue;
            }
            groups[i] += nums[idx];
            if (dfs(nums, idx - 1, groups, k, size)) {
                return true;
            }
            groups[i] -= nums[idx];
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
