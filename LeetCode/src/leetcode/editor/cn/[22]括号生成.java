//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3060 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        final String left = "(";
        final String right = ")";
        List<List<String>> dp = new ArrayList<>();
        List<String> init = new ArrayList<>();
        dp.add(init);
        init.add("()");
        while (dp.size() < n) {
            int curN = dp.size() + 1;
            List<String> curList = new ArrayList<>();
            dp.add(curList);
            for (int p = 0; p < curN; p++) {
                int q = curN - 1 - p;
                if (p == 0) {
                    for (String s : dp.get(q - 1)) {
                        curList.add(left + right + s);
                    }
                } else if (q == 0) {
                    for (String s : dp.get(p - 1)) {
                        curList.add(left + s + right);
                    }
                } else {
                    for (String s1 : dp.get(p - 1)) {
                        for (String s2 : dp.get(q - 1)) {
                            curList.add(left + s1 + right + s2);
                        }
                    }
                }
            }
        }
        return dp.get(n - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
