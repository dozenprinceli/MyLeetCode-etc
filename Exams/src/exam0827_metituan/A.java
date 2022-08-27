package exam0827_metituan;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 15:47
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        String originStr = scan.next();
        String regexStr = scan.next();
        int cnt = 0;
        for (int i = 0; i < n - m + 1; i++) {
            boolean isMatch = true;
            for (int j = 0; j < m; j++) {
                char originChar = originStr.charAt(i + j);
                char regexChar = regexStr.charAt(j);
                if (regexChar == '*') {
                    continue;
                }
                if (regexChar != originChar) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
