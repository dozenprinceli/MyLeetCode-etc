//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 613 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.min(a.length(), b.length());
        int add = 0;
        for (int i = 0; i < n; i++) {
            int curA = Integer.parseInt(String.valueOf(a.charAt(a.length() - i - 1)));
            int curB = Integer.parseInt(String.valueOf(b.charAt(b.length() - i - 1)));
            int cur = curA + curB + add;
            if (cur > 9) {
                add = 1;
            } else {
                add = 0;
            }
            sb.insert(0, cur % 10);
        }
        if (a.length() == b.length()) {
            if (add == 1) {
                sb.insert(0, 1);
            }
            return sb.toString();
        }
        String s = a.length() > b.length() ? a : b;
        for (int i = s.length() - n - 1; i >= 0; i--) {
            int cur = Integer.parseInt(String.valueOf(s.charAt(i)));
            cur += add;
            if (cur == 10) {
                add = 1;
            } else {
                add = 0;
            }
            sb.insert(0, cur % 10);
        }
        if (add == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
