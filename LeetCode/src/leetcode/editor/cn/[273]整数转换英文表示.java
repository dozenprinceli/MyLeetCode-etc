//将非负整数 num 转换为其对应的英文表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 123
//输出："One Hundred Twenty Three"
// 
//
// 示例 2： 
//
// 
//输入：num = 12345
//输出："Twelve Thousand Three Hundred Forty Five"
// 
//
// 示例 3： 
//
// 
//输入：num = 1234567
//输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// Related Topics 递归 数学 字符串 👍 289 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final String[] numStrArr = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] digit2StrArr = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] tenthStrArr = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder ans = new StringBuilder();
        int[] digitsBy3 = new int[]{num / 1_000_000_000, num / 1_000_000 % 1_000, num / 1_000 % 1_000, num % 1000};
        String[] digitsBy3Strs = new String[]{"Billion", "Million", "Thousand", ""};
        for (int i = 0; i < 4; i++) {
            if (digitsBy3[i] != 0) {
                ans.append(get3DigitStr(digitsBy3[i])).append(" ").append(digitsBy3Strs[i]).append(" ");
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        if (ans.charAt(ans.length() - 1) == ' ') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }

    private String get3DigitStr(int num) {
        StringBuilder ans = new StringBuilder();
        int hundred = num / 100;
        int ten = num / 10 % 10;
        int one = num % 10;
        if (hundred != 0) {
            ans.append(numStrArr[hundred]).append(" Hundred ");
        }
        if (ten != 0) {
            if (ten == 1) {
                ans.append(tenthStrArr[one]).append(" ");
                one = 0;
            } else {
                ans.append(digit2StrArr[ten]).append(" ");
            }
        }
        if (one != 0) {
            ans.append(numStrArr[one]).append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
