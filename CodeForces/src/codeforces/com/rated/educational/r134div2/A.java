package codeforces.com.rated.educational.r134div2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 22:33
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            char[] firstRow = scan.next().toCharArray();
            char[] secondRow = scan.next().toCharArray();
            Map<Character, Integer> colors = new HashMap<>();
            colors.put(firstRow[0], colors.getOrDefault(firstRow[0], 0) + 1);
            colors.put(firstRow[1], colors.getOrDefault(firstRow[1], 0) + 1);
            colors.put(secondRow[0], colors.getOrDefault(secondRow[0], 0) + 1);
            colors.put(secondRow[1], colors.getOrDefault(secondRow[1], 0) + 1);
            Set<Character> keySet = colors.keySet();
            System.out.println(keySet.size() - 1);
        }
    }
}
