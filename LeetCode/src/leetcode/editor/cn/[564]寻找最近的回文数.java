//给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。 
//
// “最近的”定义为两个整数差的绝对值最小。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = "123"
//输出: "121"
// 
//
// 示例 2: 
//
// 
//输入: n = "1"
//输出: "0"
//解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n.length <= 18 
// n 只由数字组成 
// n 不含前导 0 
// n 代表在 [1, 10¹⁸ - 1] 范围内的整数 
// 
//
// Related Topics 数学 字符串 👍 266 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String nearestPalindromic(String s) {
        int n = s.length();
        List<Long> ansList = new ArrayList<>();
        ansList.add((long) Math.pow(10, n - 1) - 1);
        ansList.add((long) Math.pow(10, n) + 1);
        int isOdd = n % 2 != 0 ? 1 : 0;
        long half = Long.parseLong(s.substring(0, n / 2 + isOdd));
        ansList.add(get(half, isOdd));
        ansList.add(get(half - 1, isOdd));
        ansList.add(get(half + 1, isOdd));
        long dif = Long.MAX_VALUE;
        long cur = Long.parseLong(s);
        long ans = Long.MAX_VALUE;
        for (long num : ansList) {
            long curDif = Math.abs(num - cur);
            if (num != cur && curDif < dif) {
                dif = curDif;
                ans = num;
            } else if (curDif == dif && num < ans) {
                ans = num;
            }
        }
        return String.valueOf(ans);
    }

    private long get(long num, int isOdd) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        for (int i = sb.length() - 1 - isOdd; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
