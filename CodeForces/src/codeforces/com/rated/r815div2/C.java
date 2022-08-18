package codeforces.com.rated.r815div2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/18 21:33
 */
public class C {

    private static final int[] dRow = new int[]{-1, 0, 1, 0, -1};
    private static final int[] dCol = new int[]{0, 1, 0, -1, 0};

    private static final int[] diagRow = new int[]{-1, -1, 1, 1};
    private static final int[] diagCol = new int[]{-1, 1, 1, -1};


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[][] matrix = new int[n][m];
            List<int[]> zeros = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String[] curRow = scan.next().split("");
                for (int k = 0; k < m; k++) {
                    int cur = curRow[k].equals("0") ? 0 : 1;
                    matrix[j][k] = cur;
                    if (cur == 0) {
                        zeros.add(new int[]{j, k});
                    }
                }
            }
            process(n, m, matrix, zeros);
        }
    }

    private static void process(int n, int m, int[][] matrix, List<int[]> zeros) {
        if (zeros.size() == 0) {
            System.out.println(n * m - 2);
            return;
        }
        for (int[] zeroIdx : zeros) {
            int r = zeroIdx[0];
            int c = zeroIdx[1];
            for (int i = 0; i < 4; i++) {
                // 以0为中心的L型
                int rIdx1 = r + dRow[i];
                int cIdx1 = c + dCol[i];
                int rIdx2 = r + dRow[i + 1];
                int cIdx2 = c + dCol[i + 1];
                if (isLegal(n, m, rIdx1, cIdx1) && isLegal(n, m, rIdx2, cIdx2)) {
                    int nearCnt = matrix[rIdx1][cIdx1] + matrix[rIdx2][cIdx2];
                    if (nearCnt <= 1) {
                        System.out.println(n * m - zeros.size());
                        return;
                    }
                }
                // 以1为中心周围有2个0的L型
                rIdx1 = r + diagRow[i];
                cIdx1 = c + diagCol[i];
                if (isLegal(n, m, rIdx1, cIdx1)) {
                    if (matrix[rIdx1][cIdx1] == 0) {
                        System.out.println(n * m - zeros.size());
                        return;
                    }
                }
            }
        }
        System.out.println(n * m - zeros.size() - 1);
    }

    private static boolean isLegal(int n, int m, int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
