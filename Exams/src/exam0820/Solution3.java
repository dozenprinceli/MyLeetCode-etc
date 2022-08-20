package exam0820;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 10:55
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        double[] pi = new double[n];
        int[] ai = new int[n];
        for (int i = 0; i < n; i++) {
            pi[i] = scan.nextInt() / 100.0;
        }
        for (int i = 0; i < n; i++) {
            ai[i] = scan.nextInt();
        }
        double[] addi = new double[n];
        double max = 0;
        for (int i = 0; i < n; i++) {
            max += pi[i] * ai[i];
            addi[i] = (1 - pi[i]) * ai[i];
        }
        Arrays.sort(addi);
        for (int i = n - 1; i > n - m - 1; i--) {
            max += addi[i];
        }
        System.out.printf("%2.2f", max);
    }
}
