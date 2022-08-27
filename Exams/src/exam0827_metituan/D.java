package exam0827_metituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * TODO WA
 * @author Dozen Lee<br/>
 * 2022/8/27 15:49
 */
public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int b = scan.nextInt();
        int[] pi = new int[n];
        for (int i = 0; i < n; i++) {
            pi[i] = scan.nextInt();
        }
        int[] ti = new int[n];
        for (int i = 0; i < n; i++) {
            ti[i] = scan.nextInt();
        }

        if (pi[0] > b) {
            System.out.println(-1);
            return;
        }
        b -= pi[0];
        List<Integer> startIdxes = new ArrayList<>();
        startIdxes.add(0);
        startIdxes.add(n);
        if (Arrays.stream(pi).sum() <= b + pi[0]) {
            System.out.println(Arrays.stream(ti).max());
            return;
        }
        System.out.println(ti[0] * n);
    }
}
