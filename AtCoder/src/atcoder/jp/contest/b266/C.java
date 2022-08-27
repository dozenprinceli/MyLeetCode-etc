package atcoder.jp.contest.b266;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 19:59
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();
        int x4 = scan.nextInt();
        int y4 = scan.nextInt();
        if (get(x1, y1, x3, y3, x2, y2) * get(x1, y1, x3, y3, x4, y4) >= 0) {
            System.out.println("No");
            return;
        }
        if (get(x2, y2, x4, y4, x1, y1) * get(x2, y2, x4, y4, x3, y3) >= 0) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
    }

    private static double get(int x1, int y1, int x2, int y2, int x, int y) {
        return ((double) (y - y1)) * ((double) (x2 - x1)) - ((double) (x - x1)) * ((double) (y2 - y1));
    }
}
