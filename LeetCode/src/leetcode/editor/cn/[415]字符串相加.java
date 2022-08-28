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
    public String addStrings(String shorter, String longer) {
        if (shorter.equals("0")) {
            return longer;
        }
        if (longer.equals("0")) {
            return shorter;
        }
        if (shorter.length() > longer.length()) {
            String tmp = shorter;
            shorter = longer;
            longer = tmp;
        }
        int sLen = shorter.length();
        int lLen = longer.length();

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < sLen; i++) {
            int res = shorter.charAt(sLen - i - 1) - '0'
                    + longer.charAt(lLen - i - 1) - '0'
                    + carry;
            carry = res / 10;
            sb.append(res % 10);
        }
        for (int i = lLen - sLen - 1; i >= 0; i--) {
            int res = longer.charAt(i) - '0' + carry;
            carry = res / 10;
            sb.append(res % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
