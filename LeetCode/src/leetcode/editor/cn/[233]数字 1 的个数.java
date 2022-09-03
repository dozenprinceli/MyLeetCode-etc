//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 动态规划 👍 456 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        if (n < 10) {
            return n == 0 ? 0 : 1;
        }
        String digits = String.valueOf(n);
        return countOnesByDigit(digits.length() - 1) + getMaxDigitOnes(digits);
    }

    /**
     * 获取所有位数不超过digit的数中1的个数之和
     */
    private int countOnesByDigit(int digit) {
        if (digit < 2) {
            return digit;
        }

        int baseOne = (int) Math.pow(10, digit - 1);
        int groupOnes = 9 * getGroupCnt(digit - 1);
        return baseOne + groupOnes + countOnesByDigit(digit - 1);
    }

    /**
     * 计算不超过num且位数最大的所有数中1的个数总和
     */
    private int getMaxDigitOnes(String numStr) {
        if (numStr.length() == 1) {
            return numStr.charAt(0) == '0' ? 0 : 1;
        }

        int len = numStr.length();
        int ans = 0;
        boolean allZero = true;
        int firstDigit = numStr.charAt(0) - 48;
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) != '0') {
                allZero = false;
                String newStr = numStr.substring(i);
                ans += countDigitOne(Integer.parseInt(newStr));
                if (firstDigit == 1) {
                    ans += Integer.parseInt(newStr) + 1;
                } else {
                    ans += (int) Math.pow(10, len - 1);
                    ans += (firstDigit - 1) * getGroupCnt(len - 1);
                } break;
            }
        } if (allZero) {
            if (firstDigit == 1) {
                return 1;
            } else {
                int baseOne = (int) Math.pow(10, len - 1);
                int backOnes = (firstDigit - 1) * getGroupCnt(len - 1);
                return baseOne + backOnes;
            }
        } return ans;
    }

    /**
     * 计算n个位中出现1的个数总和, 公式为∑(i=0,n)i*C(n,i)*9^(n-i)
     */
    private int getGroupCnt(int digit) {
        int ans = 0;
        for (int i = 1; i <= digit; i++) {
            ans += i * combine(digit, i) * (int) Math.pow(9, digit - i);
        }
        return ans;
    }

    /**
     * 组合数计算C(n, m)
     */
    private int combine(int n, int m) {
        int ans = 1;
        for (int i = 0; i < m; i++) {
            ans *= n - i;
        }
        for (int i = 0; i < m; i++) {
            ans /= i + 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
