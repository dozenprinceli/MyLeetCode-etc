//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5587 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String curOdd = getLongest(s, i, i);
            if (i != s.length() - 1) {
                String curEven = getLongest(s, i, i + 1);
                if (curEven.length() > ans.length()) {
                    ans = curEven;
                }
            }
            if (curOdd.length() > ans.length()) {
                ans = curOdd;
            }
        }
        return ans;
    }

    private String getLongest(String s, int left, int right) {
        if (s.charAt(left) != s.charAt(right)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s.substring(left, right + 1));
        left--;
        right++;
        while (left >= 0 && right <= s.length() - 1) {
            if (!(s.charAt(left) == s.charAt(right))) {
                break;
            }
            char cur = s.charAt(left);
            sb.insert(0, cur);
            sb.append(cur);
            left--;
            right++;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
