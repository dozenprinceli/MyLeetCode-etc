//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
// 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 注意: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["This", "is", "an", "example", "of", "text", "justification."], 
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 
//输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 
//输入:words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 2
//0
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] 由小写英文字母和符号组成 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
//
// Related Topics 数组 字符串 模拟 👍 293 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        int curLen = 0;
        while (left < words.length) {
            if (right == words.length) {
                ans.add(genLastRow(words, left, maxWidth));
                break;
            }
            String curRight = words[right];
            if (curLen + curRight.length() <= maxWidth) {
                curLen += words[right].length() + 1;
                right++;
            } else {
                ans.add(genNormalRow(words, left, right, maxWidth));
                left = right;
                curLen = 0;
            }
        }
        return ans;
    }

    private String genNormalRow(String[] words, int left, int right, int width) {
        if (right - left == 1) {
            StringBuilder ans = new StringBuilder(words[left]);
            for (int i = 0; i < width - words[left].length(); i++) {
                ans.append(" ");
            }
            return ans.toString();
        }
        int wordsLen = 0;
        for (int i = left; i < right; i++) {
            wordsLen += words[i].length();
        }
        int spaces = width - wordsLen;

        int spaceLen = spaces / (right - left - 1);
        StringBuilder spaceBuilder = new StringBuilder();
        for (int i = 0; i < spaceLen; i++) {
            spaceBuilder.append(" ");
        }
        String space = spaceBuilder.toString();

        int rest = spaces % (right - left - 1);
        StringBuilder ans = new StringBuilder();
        for (int i = left; i < right; i++) {
            ans.append(words[i]);
            if (i != right - 1) {
                ans.append(space);
                if (rest > 0) {
                    ans.append(" ");
                    rest--;
                }
            }
        }
        return ans.toString();
    }

    private String genLastRow(String[] words, int start, int width) {
        StringBuilder ans = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            ans.append(words[i]).append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        int spaces = width - ans.length();
        for (int i = 0; i < spaces; i++) {
            ans.append(" ");
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
