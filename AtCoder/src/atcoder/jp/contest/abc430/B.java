package atcoder.jp.contest.abc430;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                square[i][j] = line.charAt(j) == '#' ? 1 : 0;
            }
        }
        Set<String> patterns = getStrings(n, m, square);
        System.out.println(patterns.size());
    }

    private static Set<String> getStrings(int n, int m, int[][] square) {
        Set<String> patterns = new HashSet<>();
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < n - m + 1; j++) {
                int pattern = 0;
                for (int r = i; r < i + m; r++) {
                    for (int c = j; c < j + m; c++) {
                        if (square[r][c] > 0) pattern += 1 << ((r - i) * m + c - j);
                    }
                }
                patterns.add(Integer.toBinaryString(pattern));
            }
        }
        return patterns;
    }
}
