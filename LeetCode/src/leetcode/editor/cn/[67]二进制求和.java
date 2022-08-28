//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 864 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.min(a.length(), b.length());
        int add = 0;
        for (int i = 0; i < n; i++) {
            int curA = a.charAt(a.length() - i - 1) == '1' ? 1 : 0;
            int curB = b.charAt(b.length() - i - 1) == '1' ? 1 : 0;
            int cur = curA + curB + add;
            if (cur > 1) {
                add = 1;
            } else {
                add = 0;
            }
            sb.insert(0, cur % 2);
        }
        if (a.length() == b.length()) {
            if (add == 1) {
                sb.insert(0, 1);
            }
            return sb.toString();
        }
        String s = a.length() > b.length() ? a : b;
        for (int i = s.length() - n - 1; i >= 0; i--) {
            int cur = s.charAt(i) == '1' ? 1 : 0;
            cur += add;
            if (cur == 2) {
                add = 1;
            } else {
                add = 0;
            }
            sb.insert(0, cur % 2);
        }
        if (add == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
