//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1181 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        while (rEnd > rStart && cEnd > cStart) {
            for (int i = cStart; i <= cEnd; i++) {
                ans.add(matrix[rStart][i]);
            }
            for (int i = rStart + 1; i <= rEnd - 1; i++) {
                ans.add(matrix[i][cEnd]);
            }
            for (int i = cEnd; i >= cStart; i--) {
                ans.add(matrix[rEnd][i]);
            }
            for (int i = rEnd - 1; i >= rStart + 1; i--) {
                ans.add(matrix[i][cStart]);
            }
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
        }
        boolean isEnd = rEnd < rStart || cEnd < cStart;
        if (!isEnd) {
            if (rEnd == rStart) {
                for (int i = cStart; i <= cEnd; i++) {
                    ans.add(matrix[rStart][i]);
                }
            } else {
                for (int i = rStart; i <= rEnd; i++) {
                    ans.add(matrix[i][cStart]);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
