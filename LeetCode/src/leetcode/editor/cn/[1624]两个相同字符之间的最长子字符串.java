//给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。 
//
// 子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "aa"
//输出：0
//解释：最优的子字符串是两个 'a' 之间的空子字符串。 
//
// 示例 2： 
//
// 输入：s = "abca"
//输出：2
//解释：最优的子字符串是 "bc" 。
// 
//
// 示例 3： 
//
// 输入：s = "cbzxy"
//输出：-1
//解释：s 中不存在出现出现两次的字符，所以返回 -1 。
// 
//
// 示例 4： 
//
// 输入：s = "cabbac"
//输出：4
//解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// s 只含小写英文字母 
// 
//
// Related Topics 哈希表 字符串 👍 19 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] letterIntervals = new int[][]{
                {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0},
                {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0},
                {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0},
                {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0}, {-1, 0},
                {-1, 0}, {-1, 0},
        };
        for (int i = 0; i < s.length(); i++) {
            int letterIdx = s.charAt(i) - 97;
            if (letterIntervals[letterIdx][0] == -1) {
                letterIntervals[letterIdx][0] = i;
            } else {
                letterIntervals[letterIdx][1] = i;
            }
        }
        int max = -1;
        for (int[] interval : letterIntervals) {
            if (interval[1] == 0) {
                continue;
            }
            max = Math.max(max, interval[1] - interval[0] - 1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
