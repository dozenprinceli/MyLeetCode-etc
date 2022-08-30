package codeforces.com.rated.r817div4;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/30 22:21
 */
public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            String queue = scan.next();
            // 初始value
            long curVal = 0;
            for (int j = 0; j < n; j++) {
                if (queue.charAt(j) == 'L') {
                    curVal += j;
                } else {
                    curVal += n - j - 1;
                }
            }

            int left = 0, right = n - 1;
            int lMax = n / 2, rMax = n % 2 == 0 ? n / 2 - 1 : n / 2;
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < n; j++) {
                while (left < lMax && queue.charAt(left) == 'R') {
                    left++;
                }
                while (right > rMax && queue.charAt(right) == 'L') {
                    right--;
                }
                boolean noWay = left >= lMax && right <= rMax;
                if (!noWay) {
                    if (left + 1 < n - right) {
                        curVal += n - 2L * left - 1;
                        left++;
                    } else {
                        curVal += 2L * right - n + 1;
                        right--;
                    }
                }
                ans.append(curVal).append(" ");
            }
            ans.deleteCharAt(ans.length() - 1);
            System.out.println(ans);
        }
    }
}
