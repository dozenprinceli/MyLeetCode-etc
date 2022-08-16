package codeforces.com.c71;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 1:06
 */
public class A_WayTooLongWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = scan.nextInt();
        for (int i = 0; i < lines; i++) {
            String curLine = scan.next();
            if (curLine.length() > 10) {
                StringBuffer sb = new StringBuffer();
                sb.append(curLine.charAt(0));
                sb.append(curLine.length() - 2);
                sb.append(curLine.charAt(curLine.length() - 1));
                curLine = sb.toString();
            }
            System.out.println(curLine);
        }
        scan.close();
    }
}
