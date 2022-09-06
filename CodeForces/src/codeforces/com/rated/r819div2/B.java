package codeforces.com.rated.r819div2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * TODO TLE
 * @author Dozen Lee<br/>
 * 2022/9/6 22:26
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int test = 0; test < testCases; test++) {
            int n = scan.nextInt();
            int sum = scan.nextInt();
            boolean hasAns = (n % 2 != 0 || sum % 2 == 0) && n <= sum;
            if (!hasAns) {
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            if (n % 2 != 0) { // n is odd
                for (int i = 0; i < n - 1; i++) {
                    out.print(1 + " ");
                }
                out.println(sum - n + 1);
            } else { // n is even
                for (int i = 0; i < n - sum % n; i++) {
                    out.print((sum / n) + " ");
                }
                for (int i = n - sum % n; i < n; i++) {
                    out.print((sum / n + 1) + " ");
                }
                out.println();
            }
            out.flush();
        }
    }
}
