package exam0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 10:26
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();
        int d1 = scan.nextInt();
        int d2 = scan.nextInt();
        int d3 = scan.nextInt();
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Math.abs(x1 - i) + Math.abs(y1 - j) == d1) {
                    if (Math.abs(x2 - i) + Math.abs(y2 - j) == d2) {
                        if (Math.abs(x3 - i) + Math.abs(y3 - j) == d3) {
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
