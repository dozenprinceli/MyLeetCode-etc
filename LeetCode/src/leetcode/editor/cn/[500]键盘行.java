//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
//
// Related Topics 数组 哈希表 字符串 👍 215 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final String[] ROW = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String wordOri : words) {
            String word = wordOri.toLowerCase();
            char firstChar = word.charAt(0);
            for (String s : ROW) {
                if (s.contains(String.valueOf(firstChar))) {
                    for (int i = 0; i < word.length(); i++) {
                        if (!s.contains(String.valueOf(word.charAt(i)))) break;
                        if (i == word.length() - 1) res.add(wordOri);
                    }

                    break;
                }
            }
        }

        String[] resStr = new String[res.size()];
        return res.toArray(resStr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
