package codeforces.com.rated.r817div4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO NOT FINISHED
 * @author Dozen Lee<br/>
 * 2022/8/30 22:21
 */
public class F {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            if (n == 1 || m == 1) {
                System.out.println("NO");
                continue;
            }
            char[][] board = new char[n][m];
            for (int j = 0; j < n; j++) {
                board[j] = scan.next().toCharArray();
            }
            boolean[][] checked = new boolean[n][m];

            boolean isEnd = false;
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < m - 1; k++) {
                    if (!checkBoard(board, checked, j, k)) {
                        System.out.println("NO");
                        isEnd = true;
                        break;
                    }
                }
                if (isEnd) {
                    break;
                }
            }
            if (!isEnd) {
                System.out.println("YES");
            }
        }
    }

    private static final Map<String, int[][]> nearLocExcept = new HashMap<String, int[][]>(){{
        put("00", new int[][]{{-1, -1}});
        put("01", new int[][]{{-1, 2}});
        put("10", new int[][]{{2, -1}});
        put("11", new int[][]{{2, 2}});
    }};

    private static boolean checkBoard(char[][] board, boolean[][] checked, int r, int c) {
        if (checked[r][c]) {
            return true;
        }

        // judge if 2*2 is L-shape
        int cnt = 0;
        int[] restLoc = new int[2];
        for (int i = r; i <= r + 1; i++) {
            for (int j = c; j<= c + 1; j++) {
                if (board[i][j] == '*') {
                    cnt++;
                } else {
                    restLoc[0] = i;
                    restLoc[1] = j;
                }
            }
        }
        if (cnt != 3 && board[r][c] == '*') {
            return false;
        }
    }
}
