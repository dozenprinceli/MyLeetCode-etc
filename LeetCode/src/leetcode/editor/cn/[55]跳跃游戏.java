//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 1960 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int ptr = 0; // 当前指针
        while (ptr < nums.length) {
            if (nums[ptr] + ptr >= nums.length - 1) {
                return true;
            }
            int nextIndex = ptr; // 下一步位置
            int maxIndex = ptr; // 下下步的最远可能位置
            // 找到下下一步可以走到最远位置的下一步位置
            for (int i = ptr + 1; i <= ptr + nums[ptr]; i++) {
                if (i + nums[i] >= maxIndex) {
                    maxIndex = i + nums[i];
                    nextIndex = i;
                }
            }
            if (maxIndex == ptr) {
                return false;
            }
            ptr = nextIndex;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
