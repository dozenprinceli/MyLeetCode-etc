//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1218 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int dif = nums[0] + nums[1] + nums[2] - target;
        int length = nums.length;
        for (int p1 = 0; p1 < length - 2; p1++) {
            for (int p2 = p1 + 1; p2 < length - 1; p2++) {
                int p3 = length - 1;
                while (nums[p1] + nums[p2] + nums[p3] > target && p3 > p2) {
                    p3--;
                }
                if (p3 != length - 1) {
                    int temp = nums[p1] + nums[p2] + nums[p3 + 1] - target;
                    dif = temp < Math.abs(dif) ? temp : dif;
                }
                if (p3 <= p2) {
                    break;
                }
                int helper = nums[p1] + nums[p2] + nums[p3] - target;
                dif = Math.abs(helper) < Math.abs(dif) ? helper : dif;
            }
        }

        return target + dif;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
