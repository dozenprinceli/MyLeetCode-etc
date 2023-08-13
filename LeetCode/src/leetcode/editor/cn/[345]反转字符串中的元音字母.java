//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 316 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (right > left && !isVowel(chars[right])) {
                right--;
            }
            if (isVowel(chars[left]) && isVowel(chars[right])) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
            }
            left++;
            right--;
        }
        String retStr = new String(chars);
        System.gc();
        return retStr;
    }

    boolean isVowel(char c) {
        for (char ch : vowels) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    final char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
}
//leetcode submit region end(Prohibit modification and deletion)
