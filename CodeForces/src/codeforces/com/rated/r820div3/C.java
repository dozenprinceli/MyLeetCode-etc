package codeforces.com.rated.r820div3;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/9/12 22:21
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int t = 0; t < testCases; t++) {
            String s = scan.next();
            int len = s.length();
            int start = s.charAt(0);
            int end = s.charAt(s.length() - 1);
            System.out.print(Math.abs(start - end) + " ");
            StringBuilder ans = new StringBuilder("1 ");
            int ansLen = 1;
            if (start == end) {
                for (int i = 1; i < len; i++) {
                    if (s.charAt(i) == start) {
                        ans.append(i + 1).append(" ");
                        ansLen++;
                    }
                }
                System.out.println(ansLen);
                ans.deleteCharAt(ans.length() - 1);
                System.out.println(ans);
                continue;
            }
            Comparator<int[]> compare = (o1, o2) -> {
                int multi = start > end ? -1 : 1;
                return multi * (o1[1] - o2[1]);
            };
            PriorityQueue<int[]> indicesQueue = new PriorityQueue<>(compare);
            for (int i = 1; i < len - 1; i++) {
                indicesQueue.add(new int[]{i + 1, s.charAt(i)});
            }
            if (start < end) {
                while (!indicesQueue.isEmpty() && indicesQueue.peek()[1] < start) {
                    indicesQueue.poll();
                }
                while (!indicesQueue.isEmpty() && indicesQueue.peek()[1] <= end) {
                    ans.append(indicesQueue.poll()[0]).append(" ");
                    ansLen++;
                }
            } else {
                while (!indicesQueue.isEmpty() && indicesQueue.peek()[1] > start) {
                    indicesQueue.poll();
                }
                while (!indicesQueue.isEmpty() && indicesQueue.peek()[1] >= end) {
                    ans.append(indicesQueue.poll()[0]).append(" ");
                    ansLen++;
                }
            }
            ans.append(len);
            System.out.println(ansLen + 1);
            System.out.println(ans);
        }
    }
}
