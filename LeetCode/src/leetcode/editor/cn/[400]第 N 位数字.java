//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 343 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        if (n < 9) {
            return n;
        }
        long prevCnt = 0;
        int digit = 0;
        while (true) {
            long cur = 9 * (long) Math.pow(10, digit) * (digit + 1);
            prevCnt += cur;
            digit++;
            if (prevCnt >= n) {
                prevCnt -= cur;
                break;
            }
        }
        int move = n - (int) prevCnt;
        int idx = move / digit;
        if (move % digit == 0) {
            return ((int) Math.pow(10, digit - 1) + idx - 1) % 10;
        } else {
            return String.valueOf((int) Math.pow(10, digit - 1) + idx).charAt(move % digit - 1) - 48;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
