package exam0820;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/20 10:22
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String strA = scan.next();
        String strB = scan.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strA.charAt(i)).append(strB.charAt(i));
        }
        System.out.println(sb);
    }
}
