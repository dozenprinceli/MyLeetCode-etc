//一个 n x n 的二维网络 board 仅由 0 和 1 组成 。每次移动，你能任意交换两列或是两行的位置。 
//
// 返回 将这个矩阵变为 “棋盘” 所需的最小移动次数 。如果不存在可行的变换，输出 -1。 
//
// “棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
//输出: 2
//解释:一种可行的变换方式如下，从左到右：
//第一次移动交换了第一列和第二列。
//第二次移动交换了第二行和第三行。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: board = [[0, 1], [1, 0]]
//输出: 0
//解释: 注意左上角的格值为0时也是合法的棋盘，也是合法的棋盘.
// 
//
// 示例 3: 
//
// 
//
// 
//输入: board = [[1, 0], [1, 0]]
//输出: -1
//解释: 任意的变换都不能使这个输入变为合法的棋盘。
// 
//
// 
//
// 提示： 
//
// 
// n == board.length 
// n == board[i].length 
// 2 <= n <= 30 
// board[i][j] 将只包含 0或 1 
// 
//
// Related Topics 位运算 数组 数学 矩阵 👍 52 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int[] oppo = new int[n];
        for (int i = 0; i < n; i++) {
            oppo[i] = board[0][i] ^ 1;
        }
        for (int[] ints : board) {
            if (!Arrays.equals(ints, board[0]) && !Arrays.equals(ints, oppo)) {
                return -1;
            }
        }
        if (n % 2 == 0) {
            // Legality judge
            for (int[] row : board) {
                if (getRowSum(row) != n / 2) {
                    return -1;
                }
            }
            for (int i = 0; i < n; i++) {
                if (getColSum(board, i) != n / 2) {
                    return -1;
                }
            }

            int step;
            int oddOnes = 0;
            int evenOnes = 0;
            for (int i = 0; i < n; i += 2) {
                oddOnes += board[0][i];
                evenOnes += board[0][i + 1];
            }
            step = Math.min(oddOnes, evenOnes);
            oddOnes = 0;
            evenOnes = 0;
            for (int i = 0; i < n; i += 2) {
                oddOnes += board[i][0];
                evenOnes += board[i + 1][0];
            }
            step += Math.min(oddOnes, evenOnes);
            return step;
        } else {
            int totalSum = 0;
            for (int[] row : board) {
                totalSum += getRowSum(row);
            }
            if (totalSum != n * n / 2 && totalSum != n * n / 2 + 1) {
                return -1;
            }
            boolean mainOne = totalSum == n * n / 2 + 1;
            int oneMainCnt = 0;
            for (int[] row : board) {
                int rowSum = getRowSum(row);
                if (rowSum == n / 2 + 1) {
                    oneMainCnt++;
                } else if (rowSum != n / 2) {
                    return -1;
                }
            }
            if (mainOne && oneMainCnt == n / 2 + 1 || !mainOne && oneMainCnt == n / 2) {
                int resNum = mainOne ? 0 : 1;
                int idx = 0;

                int colStep = 0;
                for (int i = 0; i < n; i++) {
                    int curRowSum = getRowSum(board[i]);
                    if (curRowSum == n / 2 + 1 && mainOne || curRowSum == n / 2 && !mainOne) {
                        idx = i;
                        break;
                    }
                }
                for (int i = 0; i < n; i += 2) {
                    if (board[idx][i] == resNum) {
                        colStep++;
                    }
                }

                int rowStep = 0;
                for (int i = 0; i < n; i++) {
                    int curColSum = getColSum(board, i);
                    if (curColSum == n / 2 + 1 && mainOne || curColSum == n / 2 && !mainOne) {
                        idx = i;
                        break;
                    }
                }
                for (int i = 0; i < n; i += 2) {
                    if (board[i][idx] == resNum) {
                        rowStep++;
                    }
                }

                return rowStep + colStep;
            } else {
                return -1;
            }
        }
    }

    private int getRowSum(int[] row) {
        int sum = 0;
        for (int num : row) {
            sum += num;
        }
        return sum;
    }

    private int getColSum(int[][] board, int col) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum += board[i][col];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
