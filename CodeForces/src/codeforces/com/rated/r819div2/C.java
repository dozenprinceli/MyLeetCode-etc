package codeforces.com.rated.r819div2;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/9/6 22:26
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int test = 0; test < testCases; test++) {
            int n = scan.nextInt();
            String brackets = scan.next();
            List<Integer> depths = new ArrayList<>(n);
            Deque<Integer> stk = new LinkedList<>();
            for (char c : brackets.toCharArray()) {
                if (c == '(') {
                    if (stk.isEmpty()) {
                        stk.push(1);
                    } else {
                        stk.push(stk.peek() + 1);
                    }
                    depths.add(stk.peek());
                } else {
                    stk.pop();
                }
            }
            int ans = 1;
            for (int i = 0; i < n - 1; i++) {
                if (depths.get(i) < depths.get(i + 1)) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
