package array;

import org.junit.Test;

/**
 * @author Dozen Lee<br/>
 * 2022/8/21 6:07
 */
public class Array04 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int minRow = m;
        int minCol = n;
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        return minRow * minCol;
    }

    @Test
    public void test598() {
        int m = 26;
        int n = 17;
        int[][] ops = new int[][]{
                {20, 10}, {26, 11}, {2, 11}, {4, 16}, {2, 3},
                {23, 13}, {7, 15}, {11, 11}, {25, 13}, {11, 13},
                {13, 11}, {13, 16}, {26, 17}};
        System.out.println(maxCount(m, n, ops));
    }
}
