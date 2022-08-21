//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
//
// Related Topics 字符串 👍 179 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        if (s.equals("")) {
            return 0;
        }
        int ans = 1;
        boolean isSpaceArea = false;
        for (int i = 0; i < s.length(); i++) {
            if (!isSpaceArea && s.charAt(i) == ' ') {
                ans++;
                isSpaceArea = true;
            }
            if (s.charAt(i) != ' ') {
                isSpaceArea = false;
            }
        }
        ans -= s.charAt(0) == ' ' ? 1 : 0;
        ans -= s.charAt(s.length() - 1) == ' ' ? 1 : 0;
        return Math.max(0, ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
