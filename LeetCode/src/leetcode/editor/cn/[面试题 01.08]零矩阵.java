//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
//
// Related Topics 数组 哈希表 矩阵 👍 82 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] col0 = new boolean[col];
        for (int i = 0; i < row; i++) {
            boolean isZeroRow = false;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    col0[j] = true;
                    for (int k = 0; k < col; k++) {
                        if (matrix[i][k] == 0) {
                            col0[k] = true;
                        } else {
                            matrix[i][k] = 0;
                        }
                    }
                    isZeroRow = true;
                }
                if (isZeroRow) {
                    break;
                }
            }
        }
        for (int c = 0; c < col; c++) {
            if (col0[c]) {
                for (int r = 0; r < row; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
