//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 790 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int curNum = 1;
        int curLayer = 0;
        while (curLayer < n / 2) {
            int start = curLayer;
            int end = n - curLayer - 1;
            for (int i = start; i <= end; i++) {
                ans[start][i] = curNum;
                curNum++;
            }
            for (int i = start + 1; i <= end - 1; i++) {
                ans[i][end] = curNum;
                curNum++;
            }
            for (int i = end; i >= start; i--) {
                ans[end][i] = curNum;
                curNum++;
            }
            for (int i = end - 1; i >= start + 1; i--) {
                ans[i][start] = curNum;
                curNum++;
            }
            curLayer++;
        }
        if (n % 2 == 1) {
            ans[n / 2][n / 2] = n * n;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
