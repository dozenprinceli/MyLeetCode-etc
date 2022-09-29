package matrix;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/9/30 0:43
 */
public class Matrix03 {
    @Test
    public void test01_08() {
        int[][] matrix = new int[][]{{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

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
