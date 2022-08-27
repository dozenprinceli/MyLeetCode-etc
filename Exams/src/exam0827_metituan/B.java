package exam0827_metituan;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 15:49
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Deque<Integer> stk = new LinkedList<>();
        boolean[] op = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            stk.push(scan.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            int curOp = stk.pop();
            if (!op[curOp]) {
                sb.append(curOp).append(" ");
                op[curOp] = true;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (!op[i]) {
                sb.append(i).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
