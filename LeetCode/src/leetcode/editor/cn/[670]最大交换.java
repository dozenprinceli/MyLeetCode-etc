//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 260 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) < numStr.charAt(i + 1)) {
                int maxIdx = numStr.length() - 1;
                for (int j = numStr.length() - 1; j > i; j--) {
                    if (numStr.charAt(j) > numStr.charAt(maxIdx)) {
                        maxIdx = j;
                    }
                }
                for (int j = 0; j < i + 1; j++) {
                    if (numStr.charAt(j) < numStr.charAt(maxIdx)) {
                        char[] chars = numStr.toCharArray();
                        chars[j] = (char) (chars[j] ^ chars[maxIdx]);
                        chars[maxIdx] = (char) (chars[j] ^ chars[maxIdx]);
                        chars[j] = (char) (chars[j] ^ chars[maxIdx]);
                        return Integer.parseInt(new String(chars));
                    }
                }
            }
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
