//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 434 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {
        if (s.equals("()")) return 1;
        int ans = 0;
        int p = 0, q = 0;
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') q++;
            else q--;
            if (q == 0) {
                if (i == p + 1) ans += 1;
                else ans += 2 * scoreOfParentheses(s.substring(p + 1, i));
                p = i + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
