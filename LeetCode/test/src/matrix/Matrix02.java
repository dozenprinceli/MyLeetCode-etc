package matrix;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/8/23 1:01
 */
public class Matrix02 {
    @Test
    public void test782() {
        int[][] test = new int[][]{
                {1, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 0, 1, 1}};
        System.out.println(movesToChessboard(test));
    }

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

            int step = 0;
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
                int mainNum = mainOne ? 1 : 0;
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
//                if (firstRowSum == n / 2 + 1 && mainOne) {
//                    // step1
//                    for (int i = 0; i < n; i += 2) {
//                        if (board[0][i] == resNum) {
//                            step1++;
//                        }
//                    }
//                    for (int i = 0; i < n; i++) {
//                        if (board[0][i] == mainNum) {
//                            idx = i;
//                            break;
//                        }
//                    }
//                    for (int i = 0; i < n; i += 2) {
//                        if (board[i][idx] == resNum) {
//                            step1++;
//                        }
//                    }
//                    return step1;
//                } else {
//                    // step2
//                    for (int i = 0; i < n; i += 2) {
//                        if (board[i][0] == resNum) {
//                            step2++;
//                        }
//                    }
//                    for (int i = 0; i < n; i++) {
//                        if (board[i][0] == mainNum) {
//                            idx = i;
//                            break;
//                        }
//                    }
//                    for (int i = 0; i < n; i += 2) {
//                        if (board[idx][i] == resNum) {
//                            step2++;
//                        }
//                    }
//                    return step2;
//                }
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
