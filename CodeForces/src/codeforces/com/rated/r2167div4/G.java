package codeforces.com.rated.r2167div4;

import java.util.Arrays;
import java.util.Scanner;

public class G {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            long[] an = new long[l];
            long[] cn = new long[l];
            for (int j = 0; j < l; j++) {
                an[j] = sc.nextLong();
            }
            for (int j = 0; j < l; j++) {
                cn[j] = sc.nextLong();
            }
            process(an, cn);
        }
    }

    private static void process(long[] an, long[] cn) {
        long[] remains = new long[an.length];
        System.arraycopy(cn, 0, remains, 0, an.length);
        for (int i = 1; i < an.length; i++) {
            for (int j = 0; j < i; j++) {
                if (an[i] >= an[j]) remains[i] = Math.max(remains[i], remains[j] + cn[i]);
            }
        }
        long total = Arrays.stream(cn).sum();
        long maxRemain = Arrays.stream(remains).max().orElse(0);
        System.out.println(total - maxRemain);
    }
}
