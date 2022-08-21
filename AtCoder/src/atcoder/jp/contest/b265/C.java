package atcoder.jp.contest.b265;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO TLE
 * @author Dozen Lee<br/>
 * 2022/8/21 19:57
 */
public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();
        char[][] grid = new char[row][col];
        for (int i = 0; i < row; i++) {
            String[] curRow = scan.next().split("");
            for (int j = 0; j < col; j++) {
                grid[i][j] = curRow[j].charAt(0);
            }
        }

        Map<Integer, Map<Integer, Boolean>> hasFooted = new HashMap<>();
        Map<Integer, Boolean> zero = new HashMap<>();
        zero.put(0, true);
        hasFooted.put(0, zero);
        int[] lastStep = new int[2];
        int curRow = 0;
        int curCol = 0;
        boolean isEnd = false;
        while (!isEnd) {
            char op = grid[curRow][curCol];
            switch (op) {
                case 'U':
                    if (curRow == 0) {
                        isEnd = true;
                    } else {
                        curRow--;
                    }
                    break;
                case 'D':
                    if (curRow == row - 1) {
                        isEnd = true;
                    } else {
                        curRow++;
                    }
                    break;
                case 'L':
                    if (curCol == 0) {
                        isEnd = true;
                    } else {
                        curCol--;
                    }
                    break;
                case 'R':
                    if (curCol == col - 1) {
                        isEnd = true;
                    } else {
                        curCol++;
                    }
                    break;
                default:
            }
            if (isEnd) {
                lastStep[0] = curRow + 1;
                lastStep[1] = curCol + 1;
            } else {
                Map<Integer, Boolean> curRowMap = hasFooted.getOrDefault(curRow, new HashMap<>());
                if (curRowMap.getOrDefault(curCol, null) != null) {
                    System.out.println(-1);
                    return;
                } else {
                    curRowMap.put(curCol, true);
                }
            }
        }
        System.out.println(lastStep[0] + " " + lastStep[1]);
    }
}
