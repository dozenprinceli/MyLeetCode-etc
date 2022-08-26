//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
//
// Related Topics 数组 双指针 字符串 排序 👍 312 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String t, List<String> dictionary) {
        List<String> ansList = new ArrayList<>();
        for (String s : dictionary) {
            if (isSubsequence(s, t)) {
                ansList.add(s);
            }
        }
        ansList.sort((o1, o2) -> {
            int diff = o1.length() - o2.length();
            if (diff == 0) {
                return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
            } else {
                return -diff;
            }
        });
        return ansList.size() == 0 ? "" : ansList.get(0);
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        int tPtr = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            boolean hasLetter = false;
            while (tPtr < t.length()) {
                if (t.charAt(tPtr) == curChar) {
                    hasLetter = true;
                    tPtr++;
                    break;
                }
                tPtr++;
            }
            if (!hasLetter) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
