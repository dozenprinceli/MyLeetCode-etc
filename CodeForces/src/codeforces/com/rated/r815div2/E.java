package codeforces.com.rated.r815div2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/18 21:33
 */
public class E {
    // TODO
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        Map<Integer, Integer> numFreq = new HashMap<>();
        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curNum = scan.nextInt();
                square[i][j] = curNum;
                numFreq.put(curNum, numFreq.getOrDefault(curNum, 0) + 1);
            }
        }
        if (k >= numFreq.size()) {
            System.out.println(k - numFreq.size());
            return;
        }
        int steps = 0;
        for (Integer curFreq : numFreq.values()) {
            if (curFreq == 1) {
                k--;
                steps++;
            }
            if (k == numFreq.size()) {
                System.out.println(steps);
                return;
            }
        }
    }
}
