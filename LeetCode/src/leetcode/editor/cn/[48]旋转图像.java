//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 1397 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int layers = (n + 1) >> 1;
        for (int start = 0; start < layers; start++) {
            int end = n - start - 1;
            if (start == end) {
                return;
            }
            int[] buffer = new int[n - 2 * start - 1];
            for (int i = start + 1; i <= end; i++) {
                buffer[i - start - 1] = matrix[start][i];
            }
            for (int i = start; i <= end - 1; i++) {
                matrix[start][end - i + start] = matrix[i][start];
            }
            for (int i = end - 1; i >= start; i--) {
                matrix[i][start] = matrix[end][i];
            }
            for (int i = start + 1; i <= end; i++) {
                matrix[end][end - i + start] = matrix[i][end];
            }
            for (int i = 0; i < buffer.length; i++) {
                matrix[start + i + 1][end] = buffer[i];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
