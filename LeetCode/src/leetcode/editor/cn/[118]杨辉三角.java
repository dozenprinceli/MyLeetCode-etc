//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 819 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lst = new ArrayList<>(numRows);
        List<Integer> pre = new ArrayList<>(1);
        pre.add(1);
        lst.add(pre);

        for (int row = 2; row <= numRows; row++) {
            List<Integer> cur = new ArrayList<>(row);
            for (int col = 0; col < row; col++) {
                if (col == 0 || col == row - 1) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(col - 1) + pre.get(col));
                }
            }
            lst.add(cur);
            pre = cur;
        }

        return lst;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
