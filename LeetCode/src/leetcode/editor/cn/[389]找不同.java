//给定两个字符串 s 和 t ，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 
//输入：s = "", t = "y"
//输出："y"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 339 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sCharFreq = new HashMap<>();
        Map<Character, Integer> tCharFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            sCharFreq.put(c, sCharFreq.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tCharFreq.put(c, tCharFreq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : tCharFreq.entrySet()) {
            if (!Objects.equals(sCharFreq.getOrDefault(entry.getKey(), 0), entry.getValue())) {
                return entry.getKey();
            }
        }
        return '\0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
