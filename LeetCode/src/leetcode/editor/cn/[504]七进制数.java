//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
//
// Related Topics 数学 👍 188 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        String isNegative = num < 0 ? "-" : "";
        StringBuilder sb = new StringBuilder();
        num = Math.abs(num);
        while (num >= 7) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.append(num);
        sb.append(isNegative);
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
