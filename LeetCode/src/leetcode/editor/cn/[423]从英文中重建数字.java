//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
//
// Related Topics 哈希表 数学 字符串 👍 184 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final Map<Integer, String> numStrMap = new HashMap<Integer, String>() {{
        put(0, "zero");
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
    }};
    private final Map<Character, Integer> firstFilterMap = new HashMap<Character, Integer>() {{
        put('w', 2);
        put('u', 4);
        put('x', 6);
        put('g', 8);
        put('z', 0);
    }};

    public String originalDigits(String s) {
        /*
            0   zero    z
            2   two     w
            4   four    u
            4   six     x
            8   eight   g

            1   one     o
            3   three   t
            5   five    f
            7   seven   s

            9   nine    rest number of 'i' or 'e'
        */
        final int[] ansFreq = new int[10];
        final Map<Character, Integer> charFreq = new HashMap<>();
        // 计数每个字母的出现次数并进行第一次筛选
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            if (firstFilterMap.containsKey(c)) {
                ansFreq[firstFilterMap.get(c)]++;
            }
        }
        // 删除第一次筛选掉的字母(正好是所有偶数)
        for (int i = 0; i < 10; i += 2) {
            for (char c : numStrMap.get(i).toCharArray()) {
                charFreq.put(c, charFreq.getOrDefault(c, 0) - ansFreq[i]);
            }
        }
        // 进行第二次筛选
        ansFreq[1] = charFreq.getOrDefault('o', 0);
        ansFreq[3] = charFreq.getOrDefault('t', 0);
        ansFreq[5] = charFreq.getOrDefault('f', 0);
        ansFreq[7] = charFreq.getOrDefault('s', 0);
        ansFreq[9] = charFreq.getOrDefault('i', 0) - ansFreq[5];
        // 进行排序
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < ansFreq[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
