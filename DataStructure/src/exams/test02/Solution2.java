package exams.test02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 16:20
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        String order = scan.next();
        scan.close();
        char[] orders = order.toCharArray();
        boolean[][] room = new boolean[n][m];
        room[0][0] = true;
        int rowIndex = 0;
        int colIndex = 0;
        List<int[]> notCleaned = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                notCleaned.add(new int[]{i, j});
            }
        }
        notCleaned.remove(0);
        for (int i = 0; i < k; i++) {
            switch (orders[i]) {
                case 'W':
                    rowIndex--;
                    break;
                case 'A':
                    colIndex--;
                    break;
                case 'S':
                    rowIndex++;
                    break;
                case 'D':
                    colIndex++;
                    break;
            }
            room[rowIndex][colIndex] = true;
            for (int index = 0; index < notCleaned.size(); index++) {
                int curRow = notCleaned.get(index)[0];
                int curCol = notCleaned.get(index)[1];
                if (room[curRow][curCol]) {
                    notCleaned.remove(index);
                    break;
                }
            }
            if (notCleaned.size() == 0) {
                System.out.println("Yes");
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("No");
        System.out.println(notCleaned.size());
    }
}
