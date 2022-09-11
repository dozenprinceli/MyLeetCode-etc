//有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i]
//。 
//
// 现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资： 
//
// 
// 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。 
// 工资组中的每名工人至少应当得到他们的最低期望工资。 
// 
//
// 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10⁻⁵ 以内的答案将被接受。。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入： quality = [10,20,5], wage = [70,50,30], k = 2
//输出： 105.00000
//解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。 
//
// 示例 2： 
//
// 
//输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
//输出： 30.66667
//解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。 
//
// 
//
// 提示： 
//
// 
// n == quality.length == wage.length 
// 1 <= k <= n <= 10⁴ 
// 1 <= quality[i], wage[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 152 👎 0

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        // 新数组元素结构为{quality, wage}
        int[][] ratioArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            ratioArr[i][0] = quality[i];
            ratioArr[i][1] = wage[i];
        }
        // 按照ratio从小到大排序
        Arrays.sort(ratioArr, (o1, o2) -> {
            double ans = (double) o1[1] / o1[0] - (double) o2[1] / o2[0];
            return ans > 0 ? 1 : (ans < 0 ? -1 : 0);
        });
        // 维护一个优先队列, 存储遍历到的前i个中quality最小的k个数
        Queue<Integer> kMin = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        int curSum = 0;
        // 初始化, 前k个数求和
        for (int i = 0; i < k; i++) {
            kMin.offer(ratioArr[i][0]);
            curSum += ratioArr[i][0];
        }
        // 初始化的ans值
        double ans = curSum * (double) ratioArr[k - 1][1] / ratioArr[k - 1][0];
        // 从k+1开始, 求当前最低总工资并与ans取小
        for (int i = k; i < n; i++) {
            int curQuality = ratioArr[i][0];
            int curWage = ratioArr[i][1];
            double curRatio = (double) curWage / curQuality;
            // 若当前quality属于最小的k个(即小于之前的第k小的值)
            if (curQuality < kMin.peek()) {
                curSum -= kMin.poll();
                kMin.offer(curQuality);
                curSum += curQuality;
                ans = Math.min(ans, curSum * curRatio);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
