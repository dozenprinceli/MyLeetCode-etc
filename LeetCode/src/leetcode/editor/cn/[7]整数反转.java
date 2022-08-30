//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3582 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String numStr = String.valueOf(x);
        char[] numChars = numStr.toCharArray();

        boolean isNegative = numChars[0] == '-';
        int left = isNegative ? 1 : 0, right = numChars.length - 1;
        while (left < right) {
            char tmp = numChars[left];
            numChars[left] = numChars[right];
            numChars[right] = tmp;
            left++;
            right--;
        }

        int startIdx = isNegative ? 1 : 0;
        for (int i = startIdx; i < numChars.length; i++) {
            if (numChars[i] != '0') {
                break;
            } else {
                numChars[i] = '\0';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char numChar : numChars) {
            if (numChar != '\0') {
                sb.append(numChar);
            }
        }

        String ans = sb.toString();
        if (isLegal(ans)) {
            return Integer.parseInt(ans);
        } else {
            return 0;
        }
    }

    private boolean isLegal(String numStr) {
        boolean isNegative = numStr.charAt(0) == '-';
        String compareStr = isNegative ? String.valueOf(Integer.MIN_VALUE).substring(1) : String.valueOf(Integer.MAX_VALUE);
        if (isNegative) {
            numStr = numStr.substring(1);
        }
        int numLen = numStr.length();
        if (numLen != compareStr.length()) {
            return numLen < compareStr.length();
        }

        for (int i = 0; i < numLen; i++) {
            if (numStr.charAt(i) > compareStr.charAt(i)) {
                return false;
            } else if (numStr.charAt(i) < compareStr.charAt(i)) {
                return true;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
