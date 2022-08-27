//f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。 
//
// 
// 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。 
// 
//
// 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 0
//输出：5
//解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
// 
//
// 示例 2： 
//
// 
//输入：k = 5
//输出：0
//解释：没有匹配到这样的 x!，符合 k = 5 的条件。 
//
// 示例 3: 
//
// 
//输入: k = 3
//输出: 5
// 
//
// 
//
// 提示: 
//
// 
// 0 <= k <= 10⁹ 
// 
//
// Related Topics 数学 二分查找 👍 104 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int preimageSizeFZF(int k) {
        if (k == 0) {
            return 5;
        }
        long left = 4L * k - 1;
        long right = 5L * k + 1;
        while (left < right - 1) {
            long mid = (left + right) / 2;
            int cur = getZeros(mid);
            if (cur == k) {
                return 5;
            } else if (cur < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return 0;
    }

    private int getZeros(long num) {
        int ans = 0;
        while (num != 0) {
            ans += num / 5;
            num /= 5;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
