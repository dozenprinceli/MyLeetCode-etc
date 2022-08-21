//根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。 
//
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞
// （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律： 
//
// 
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡； 
// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活； 
// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡； 
// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活； 
// 
//
// 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返
//回下一个状态。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// 
//
// 示例 2： 
// 
// 
//输入：board = [[1,1],[1,0]]
//输出：[[1,1],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 25 
// board[i][j] 为 0 或 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。 
// 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？ 
// 
//
// Related Topics 数组 矩阵 模拟 👍 455 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] nearCnt = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nearCnt[i][j] = getNearCnt(board, i, j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int curNear = nearCnt[i][j];
                if (board[i][j] == 1) {
                    if (curNear < 2 || curNear > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    board[i][j] = curNear == 3 ? 1 : 0;
                }
            }
        }
    }

    private final int[] dRow = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private final int[] dCol = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    private int getNearCnt(int[][] board, int rIdx, int cIdx) {
        int row = board.length;
        int col = board[0].length;
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int curRow = rIdx + dRow[i];
            int curCol = cIdx + dCol[i];
            if (isLegal(row, col, curRow, curCol)) {
                cnt += board[curRow][curCol];
            }
        }
        return cnt;
    }

    private boolean isLegal(int row, int col, int rIdx, int cIdx) {
        return 0 <= rIdx && rIdx < row && 0 <= cIdx && cIdx < col;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
