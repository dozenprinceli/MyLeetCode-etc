//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度： 
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 68 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freqCnt = new HashMap<>();
        Map<Integer, Integer> numFreq = new HashMap<>();
        int ans = 0;
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            // 更新之前的freqCnt值(freqCnt[curNum]-1)
            if (numFreq.containsKey(curNum)) {
                int curNumFreq = numFreq.get(curNum);
                freqCnt.put(curNumFreq, freqCnt.get(curNumFreq) - 1);
            }
            // 更新当前频数
            if (numFreq.containsKey(curNum)) {
                numFreq.put(curNum, numFreq.get(curNum) + 1);
            } else {
                numFreq.put(curNum, 1);
            }
            // 更新新的freqCnt值(freqCnt[curNum]+1)
            freqCnt.put(numFreq.get(curNum), freqCnt.getOrDefault(numFreq.get(curNum), 0) + 1);
            // 更新maxFreq值
            maxFreq = Math.max(maxFreq, numFreq.get(curNum));
            // 判断是否符合
            if (isFit(freqCnt, maxFreq, i + 1)) {
                ans = i + 1;
            }
        }
        return ans;
    }

    private boolean isFit(Map<Integer, Integer> freqCnt, int maxFreq, int n) {
        return maxFreq == 1 ||
                freqCnt.get(1) == 1 && freqCnt.get(maxFreq) * maxFreq + 1 == n ||
                freqCnt.get(maxFreq) == 1 && freqCnt.get(maxFreq - 1) * (maxFreq - 1) + maxFreq == n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
