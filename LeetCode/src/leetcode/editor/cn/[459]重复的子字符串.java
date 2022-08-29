//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 767 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int subLen = 1; subLen <= len / 2; subLen++) {
            if (len % subLen == 0) {
                String subStr = s.substring(0, subLen);
                boolean isFit = true;
                for (int i = 1; i < len / subLen; i++) {
                    if (!s.startsWith(subStr, i * subLen)) {
                        isFit = false;
                        break;
                    }
                }
                if (isFit) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
