package codeforces.com.rated.r817div4;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/8/30 22:21
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scan.nextInt();
            Map<String, List<Integer>> strByIdx = new HashMap<>();
            // first person = 0
            for (int j = 0; j < n; j++) {
                String s = scan.next();
                List<Integer> lst = new ArrayList<>();
                lst.add(0);
                strByIdx.put(s, lst);
            }
            // second person = 1
            for (int j = 0; j < n; j++) {
                String s = scan.next();
                if (strByIdx.containsKey(s)) {
                    strByIdx.get(s).add(1);
                } else {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(1);
                    strByIdx.put(s, lst);
                }
            }
            // third person = 2
            for (int j = 0; j < n; j++) {
                String s = scan.next();
                if (strByIdx.containsKey(s)) {
                    strByIdx.get(s).add(2);
                } else {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(2);
                    strByIdx.put(s, lst);
                }
            }

            int[] ans = new int[3];
            for (List<Integer> idxes : strByIdx.values()) {
                if (idxes.size() == 1) {
                    ans[idxes.get(0)] += 3;
                } else if (idxes.size() == 2) {
                    ans[idxes.get(0)] += 1;
                    ans[idxes.get(1)] += 1;
                }
            }
            System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }
}
