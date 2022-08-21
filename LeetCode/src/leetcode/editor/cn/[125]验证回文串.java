//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 563 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!isLetterOrNum(s.charAt(left))) {
                left++;
                if (left == s.length() - 1) {
                    return true;
                }
            }
            while (!isLetterOrNum(s.charAt(right))) {
                right--;
                if (right < 0) {
                    return true;
                }
            }
            if (left < right && !isEqualIgnoreCase(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isLetterOrNum(char c) {
        return 65 <= c && c <= 90 || 97 <= c && c <= 122 || 48 <= c && c <= 57;
    }

    private boolean isEqualIgnoreCase(char c1, char c2) {
        if (65 <= c1 && c1 <= 90) {
            return c1 == c2 || c1 + 32 == c2;
        }
        if (97 <= c1 && c1 <= 122) {
            return c1 == c2 || c1 - 32 == c2;
        }
        return c1 == c2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
