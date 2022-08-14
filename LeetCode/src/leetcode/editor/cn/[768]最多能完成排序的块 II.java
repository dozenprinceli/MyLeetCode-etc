//这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。 
//
// arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
// 
//
// 我们最多能将数组分成多少块？ 
//
// 示例 1: 
//
// 
//输入: arr = [5,4,3,2,1]
//输出: 1
//解释:
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。 
// 
//
// 示例 2: 
//
// 
//输入: arr = [2,1,3,4,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
//然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。 
// 
//
// 注意: 
//
// 
// arr的长度在[1, 2000]之间。 
// arr[i]的大小在[0, 10**8]之间。 
// 
//
// Related Topics 栈 贪心 数组 排序 单调栈 👍 139 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<int[]> stk = new LinkedList<>();
        for (int cur : arr) {
            if (stk.isEmpty()) {
                stk.push(new int[]{cur, cur}); // 元素格式{min, max}
            } else {
                if (cur >= stk.peek()[1]) { // 比前面都大, 可开启一个新分组
                    stk.push(new int[]{cur, cur});
                } else if (cur < stk.peek()[0]) { // 比前一个分组的min小, 合并最小值比它大的所有分组
                    int curMax = stk.peek()[1];
                    while (!stk.isEmpty() && cur < stk.peek()[0]) {
                        stk.pop();
                    }
                    // 与前一个分组的max比较, 判断是否开启新分组
                    if (stk.isEmpty() || cur >= stk.peek()[1]) {
                        stk.push(new int[]{cur, curMax});
                    } else {
                        stk.peek()[1] = curMax;
                    }
                } // 其他情况: 处于现分组中间, 归入现分组
            }
        }
        return stk.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
