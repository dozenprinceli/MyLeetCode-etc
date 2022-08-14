package exams.test02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 17:16
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = scan.nextInt();
        }
        List<Integer> totalWays = helper(nodes, 0);
        int maxMoney = totalWays.get(0);
        for (Integer num : totalWays) {
            maxMoney = Math.max(maxMoney, num);
        }
        System.out.println(maxMoney);
    }

    private static List<Integer> helper(int[] nodes, int index) {
        int curMoney = nodes[index];
        List<Integer> res = new ArrayList<>();
        if (2 * (index + 1) > nodes.length) {
            res.add(curMoney);
            return res;
        }
        for (Integer num : helper(nodes, 2 * (index + 1) - 1)) {
            res.add(num + curMoney);
        }
        if (2 * (index + 1) + 1 <= nodes.length) {
            for (Integer num : helper(nodes, 2 * (index + 1))) {
                res.add(num + curMoney);
            }
        }
        return res;
    }
}
