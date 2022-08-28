//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 👍 988 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder res = new StringBuilder(multiByOneDigit(num1.charAt(i), num2));
            for (int j = 0; j < num1.length() - i - 1; j++) {
                res.append("0");
            }
            ans = addStringNums(ans, res.toString());
        }
        return ans;
    }

    private String multiByOneDigit(char oneDigit, String num) {
        int digit = oneDigit - '0';
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            int cur = num.charAt(i) - '0';
            int res = cur * digit + carry;
            sb.append(res % 10);
            carry = res / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private String addStringNums(String shorter, String longer) {
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
