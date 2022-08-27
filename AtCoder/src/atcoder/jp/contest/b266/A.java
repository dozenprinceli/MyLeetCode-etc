package atcoder.jp.contest.b266;

import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 19:58
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(s.charAt((s.length() - 1) / 2));
    }
}
