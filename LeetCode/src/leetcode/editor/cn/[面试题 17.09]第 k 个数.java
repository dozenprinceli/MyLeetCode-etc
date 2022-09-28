//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 209 👎 0


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.offer(1L);
        long ans = 1;
        for (int i = 0; i < k; i++) {
            long cur = queue.poll();
            ans = cur;
            if (set.add(cur * 3)) {
                queue.offer(cur * 3);
            }
            if (set.add(cur * 5)) {
                queue.offer(cur * 5);
            }
            if (set.add(cur * 7)) {
                queue.offer(cur * 7);
            }
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
