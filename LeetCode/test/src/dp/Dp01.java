package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2023/2/10 0:36
 */
public class Dp01 {

    @Test
    public void test1223() {
        int n = 2;
        int[] rollMax = new int[]{1, 1, 2, 2, 2, 3};
        System.out.println(dieSimulator(n, rollMax));
    }

    public int dieSimulator(int n, int[] rollMax) {
        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n][6];
        dp[0] = new long[]{1, 1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dp[i][j] = Arrays.stream(dp[i - 1]).sum();
                if (i - rollMax[j] > 0) {
                    int idx = i - rollMax[j] - 1;
                    dp[i][j] -= Arrays.stream(dp[idx]).sum() - dp[idx][j];
                } else if (i == rollMax[j]) {
                    dp[i][j]--;
                }
            }
        }
        return (int) (Arrays.stream(dp[n - 1]).sum() % MOD);
    }
}
