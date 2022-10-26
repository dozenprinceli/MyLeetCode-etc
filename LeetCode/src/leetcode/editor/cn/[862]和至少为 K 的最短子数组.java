//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 516 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = n + 1;
        long[] prefix = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) ans = Math.min(ans, i - deque.pollFirst());
            while (!deque.isEmpty() && prefix[deque.peekLast()] >= prefix[i]) deque.pollLast();
            deque.addLast(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
