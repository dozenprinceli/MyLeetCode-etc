package atcoder.jp.contest.b265;

import java.util.*;

/**
 * TODO WA
 * @author Dozen Lee<br/>
 * 2022/8/21 19:57
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int limit = scan.nextInt();
        int[] times = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            times[i] = scan.nextInt();
        }
        Integer[][] bonuses = new Integer[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                bonuses[i][j] = scan.nextInt();
            }
        }
        List<Integer[]> bonusList = Arrays.asList(bonuses);
        bonusList.sort(Comparator.comparingInt(o -> o[0]));

        int curRoom = 0;
        int timeSum = 0;
        for (int i = 0; i < m; i++) {
            Integer[] curBonus = bonusList.get(i);
            for (int j = curRoom; j < curBonus[0] - 1; j++) {
                timeSum += times[j];
            }
            if (limit < timeSum) {
                System.out.println("No");
                return;
            }
            limit += curBonus[1];
            curRoom = curBonus[0] - 1;
        }

        for (int i = curRoom; i < n - 1; i++) {
            timeSum += times[i];
        }
        if (timeSum <= limit) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
