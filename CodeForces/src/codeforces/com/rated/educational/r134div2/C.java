package codeforces.com.rated.educational.r134div2;

import java.util.Scanner;

/**
 * TODO WA
 * @author Dozen Lee<br/>
 * 2022/8/27 22:34
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            int[] ai = new int[n];
            int[] bi = new int[n];
            for (int j = 0; j < n; j++) {
                ai[j] = scan.nextInt();
            }
            for (int j = 0; j < n; j++) {
                bi[j] = scan.nextInt();
            }

            int[] min = new int[n];
            int[] max = new int[n];
            int ptr = 0;
            for (int j = 0; j < n; j++) {
                while (bi[ptr] < ai[j]) {
                    ptr++;
                }
                min[j] = bi[ptr] - ai[j];
                ptr = 0;
            }
            ptr = n - 1;
            int ptrA = n - 1;
            while (ptr >= 0) {
                while (ptr >= 0 && bi[ptr] >= ai[ptrA]) {
                    ptr--;
                }
                for (int j = ptr + 1; j <= ptrA; j++) {
                    max[j] = bi[ptrA] - ai[j];
                }
                ptrA = ptr;
            }

            StringBuilder minSb = new StringBuilder();
            StringBuilder maxSb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                minSb.append(min[j]).append(" ");
                maxSb.append(max[j]).append(" ");
            }
            minSb.deleteCharAt(minSb.length() - 1);
            maxSb.deleteCharAt(maxSb.length() - 1);
            System.out.println(minSb);
            System.out.println(maxSb);
        }
    }
}
