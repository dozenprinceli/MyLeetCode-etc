package exams.test02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 16:04
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        int[] orders = new int[n];
        for (int i = 0; i < n; i++) {
            orders[i] = scan.nextInt();
        }
        scan.close();
        Arrays.sort(orders);
        int res = n;
        int p = 0;
        for (int i = 0; i < n; i++) {
            int time = (i + 1) * t;
            while (p < n && orders[p] < time) {
                p++;
            }
            if (p == n) {
                break;
            } else if (orders[p] >= time) {
                res--;
                p++;
            }
        }
        System.out.println(res);
    }
}
