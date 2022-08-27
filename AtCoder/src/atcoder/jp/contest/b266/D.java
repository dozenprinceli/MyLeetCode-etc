package atcoder.jp.contest.b266;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 * @author Dozen Lee<br/>
 * 2022/8/27 19:59
 */
public class D {
    private static final int[][] distances = new int[][]{
            {0, 1, 2, 3, 4},
            {1, 0, 1, 2, 3},
            {2, 1, 0, 1, 2},
            {3, 2, 1, 0, 1},
            {4, 3, 2, 1, 0}
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<int[]> snukeInfos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            snukeInfos.add(new int[]{scan.nextInt(), scan.nextInt(), scan.nextInt()});
        }
        snukeInfos.sort(Comparator.comparingInt(o -> o[0]));
        int ptr = 0;
        while (ptr < N) {

        }
    }
}
