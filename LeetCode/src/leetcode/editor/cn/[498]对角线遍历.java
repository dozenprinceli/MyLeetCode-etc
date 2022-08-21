//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 矩阵 模拟 👍 391 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int layer = 0;
        int curIdx = 0;
        boolean direction = false;
        for (int i = 0; i < m + n; i++) {
            if (direction) {
                for (int x = 0; x <= layer; x++) {
                    int y = layer - x;
                    if (isLegal(m, n, x, y)) {
                        ans[curIdx] = mat[x][y];
                        curIdx++;
                    }
                }
            } else {
                for (int x = layer; x >= 0; x--) {
                    int y = layer - x;
                    if (isLegal(m, n, x, y)) {
                        ans[curIdx] = mat[x][y];
                        curIdx++;
                    }
                }
            }
            direction = !direction;
            layer++;
        }
        return ans;
    }

    private boolean isLegal(int m, int n, int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
