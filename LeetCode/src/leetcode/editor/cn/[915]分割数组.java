//给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得： 
//
// 
// left 中的每个元素都小于或等于 right 中的每个元素。 
// left 和 right 都是非空的。 
// left 的长度要尽可能小。 
// 
//
// 在完成这样的分组后返回 left 的 长度 。 
//
// 用例可以保证存在这样的划分方法。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,0,3,8,6]
//输出：3
//解释：left = [5,0,3]，right = [8,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,0,6,12]
//输出：4
//解释：left = [1,1,1,0]，right = [6,12]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。 
// 
//
// Related Topics 数组 👍 131 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        for (int i = n - 2; i >= 0; i--) rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        for (int i = 0; i < n - 1; i++) if (leftMax[i] <= rightMin[i + 1]) return i + 1;
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
