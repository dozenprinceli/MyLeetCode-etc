//给你一个字符串 s，最多 可以从中删除一个字符。 
//
// 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "abca"
//输出：true
//解释：你可以删除字符 'c' 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abc"
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// Related Topics 贪心 双指针 字符串 👍 601 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean flag = false;
        boolean can = true;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            if (flag) {
                can = false;
                break;
            }
            if (left + 1 == right) {
                System.gc();
                return true;
            }
            if (s.charAt(left + 1) == s.charAt(right)) {
                flag = true;
                left += 2;
                right -= 1;
                continue;
            }
            if (s.charAt(left) == s.charAt(right - 1)) {
                flag = true;
                left += 1;
                right -= 2;
                continue;
            }
            can = false;
            break;
        }
        if (can) {
            System.gc();
            return true;
        }

        left = 0;
        right = s.length() - 1;
        flag = false;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            if (flag) {
                System.gc();
                return false;
            }
            if (left + 1 == right) {
                System.gc();
                return true;
            }
            if (s.charAt(left) == s.charAt(right - 1)) {
                flag = true;
                left += 1;
                right -= 2;
                continue;
            }
            if (s.charAt(left + 1) == s.charAt(right)) {
                flag = true;
                left += 2;
                right -= 1;
                continue;
            }
            System.gc();
            return false;
        }
        System.gc();
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
