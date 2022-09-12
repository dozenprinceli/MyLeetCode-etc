package codeforces.com.rated.r820div3;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/9/12 22:21
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int t = 0; t < testCases; t++) {
            int len = scan.nextInt();
            String encoded = scan.next();
            int ptr = 0;
            StringBuilder ans = new StringBuilder();
            while (ptr < len) {
                int cur = (encoded.charAt(ptr)) - 48;
                if (cur > 2){
                    ans.append((char) (96 + cur));
                    ptr++;
                } else {
                    if (ptr < len - 3 && encoded.charAt(ptr + 3) == '0') {
                        ans.append((char) (96 + cur));
                        ptr++;
                    } else if (ptr < len - 2 && encoded.charAt(ptr + 2) == '0') {
                        cur = Integer.parseInt(encoded.substring(ptr, ptr + 2));
                        ans.append((char) (96 + cur));
                        ptr += 3;
                    } else {
                        ans.append((char) (96 + cur));
                        ptr++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
