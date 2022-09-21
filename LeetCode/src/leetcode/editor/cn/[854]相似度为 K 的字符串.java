//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。 
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
//
// Related Topics 广度优先搜索 字符串 👍 132 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    int k = Integer.MAX_VALUE;
//
//    public int kSimilarity(String s1, String s2) {
//        int n = s1.length();
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        int preK = 0;
//        // 找到所有可以交换后匹配的位置
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (chars1[i] == chars2[j] && chars2[i] == chars1[j]) {
//                    swap(chars2, i, j);
//                    preK++;
//                }
//            }
//        }
//
//        return preK + getK(chars1, chars2, 0, 0);
//    }
//
//    private int getK(char[] s1, char[] s2, int start, int cur) {
//        if (cur >= k) {
//            return k;
//        }
//
//        int n = s1.length;
//        if (start == n - 1) {
//            return Math.min(k, cur);
//        }
//
//        for (int i = start; i < n; i++) {
//            if (s1[i] == s2[i]) {
//                continue;
//            }
//            for (int j = i + 1; j < n; j++) {
//                if (s2[j] != s1[j] && s2[j] == s1[i]) {
//                    swap(s2, i, j);
//                    getK(s1, s2, i + 1, cur + 1);
//                    swap(s2, i, j);
//                    if (s2[i] == s1[j]) {
//                        break;
//                    }
//                }
//            }
//            return k;
//        }
//        return Math.min(k, cur);
//    }
//
//    private void swap(char[] chars, int i, int j) {
//        chars[i] = (char) (chars[i] ^ chars[j]);
//        chars[j] = (char) (chars[i] ^ chars[j]);
//        chars[i] = (char) (chars[i] ^ chars[j]);
//    }
//}
class Solution {
    int k = Integer.MAX_VALUE;

    public int kSimilarity(String s1, String s2) {
        return getK(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public int getK(char[] sc1, char[] sc2, int start, int cur) {
        if (cur >= k) {
            return k;
        }
        if (start == sc1.length - 1) {
            k = cur;
            return cur;
        }

        for (int i = start; i < sc1.length; i++) {
            if (sc1[i] != sc2[i]) {
                for (int j = i + 1; j < sc2.length; j++) {
                    if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) {
                        swap(sc2, i, j);
                        getK(sc1, sc2, i + 1, cur + 1);
                        swap(sc2, i, j);
                        if (sc2[i] == sc1[j]) {
                            break;
                        }
                    }
                }
                return k;
            }
        }
        k = cur;
        return cur;
    }

    public void swap(char[] sc, int i, int j) {
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
