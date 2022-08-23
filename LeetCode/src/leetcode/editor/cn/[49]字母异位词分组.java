//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1239 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            boolean hasGroup = false;
            for (List<String> group : ans) {
                if (Arrays.equals(strChars, group.get(0).toCharArray())) {
                    group.add(str);
                    hasGroup = true;
                    break;
                }
            }
            if (!hasGroup) {
                List<String> curGroup = new ArrayList<>();
                curGroup.add(String.valueOf(strChars));
                curGroup.add(str);
                ans.add(curGroup);
            }
        }
        for (List<String> group : ans) {
            group.remove(0);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
