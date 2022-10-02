//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或
//者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回
//True。 
//
// 
//
// 示例 : 
//
// 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//输出: True
//解释:
//我们可以通过以下几步将start转换成end:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(start) = len(end) <= 10000。 
// start和end中的字符串仅限于'L', 'R'和'X'。 
// 
//
// Related Topics 双指针 字符串 👍 231 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        int n = start.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        List<Integer> startL = new ArrayList<>();
        List<Integer> endL = new ArrayList<>();
        List<Integer> startR = new ArrayList<>();
        List<Integer> endR = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char curS = start.charAt(i);
            char curE = end.charAt(i);
            if (curS != 'X') {
                sb1.append(curS);
                if (curS == 'L') startL.add(i);
                else startR.add(i);
            }
            if (curE != 'X') {
                sb2.append(end.charAt(i));
                if (curE == 'L') endL.add(i);
                else endR.add(i);
            }
        }
        if (!sb1.toString().equals(sb2.toString())) return false;
        for (int i = 0; i < startL.size(); i++) {
            if (startL.get(i) < endL.get(i)) return false;
        }
        for (int i = 0; i < startR.size(); i++) {
            if (startR.get(i) > endR.get(i)) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
