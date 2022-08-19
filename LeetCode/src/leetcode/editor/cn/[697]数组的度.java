//给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,3,1]
//输出：2
//解释：
//输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
//连续子数组里面拥有相同度的有如下所示：
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,2,3,1,4,2]
//输出：6
//解释：
//数组的度是 3 ，因为元素 2 重复出现 3 次。
//所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在 1 到 50,000 范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
//
// Related Topics 数组 哈希表 👍 429 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        Map<Integer, int[]> numAppear = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int curFreq = numFreq.getOrDefault(cur, 0) + 1;
            numFreq.put(cur, curFreq);
            maxFreq = Math.max(maxFreq, curFreq);
            if (!numAppear.containsKey(cur)) {
                numAppear.put(cur, new int[]{i, i});
            } else {
                int[] curAppear = numAppear.get(cur);
                curAppear[1] = i;
            }
        }
        int shortest = nums.length;
        for (Map.Entry<Integer, int[]> curAppear : numAppear.entrySet()) {
            int curNum = curAppear.getKey();
            if (numFreq.get(curNum) == maxFreq) {
                int[] appear = curAppear.getValue();
                shortest = Math.min(shortest, appear[1] - appear[0] + 1);
            }
        }
        return shortest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
