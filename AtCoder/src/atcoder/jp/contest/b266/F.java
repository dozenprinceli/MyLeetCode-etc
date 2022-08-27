package atcoder.jp.contest.b266;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO TLE
 * @author Dozen Lee<br/>
 * 2022/8/27 20:54
 */
public class F {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<List<Integer>> vertices = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            vertices.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int ui = scan.nextInt();
            int vi = scan.nextInt();
            vertices.get(ui - 1).add(vi - 1);
            vertices.get(vi - 1).add(ui - 1);
        }
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int start = scan.nextInt() - 1;
            int end = scan.nextInt() - 1;
            if (cntPaths(vertices, start, end) == 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static int cntPaths(List<List<Integer>> vertices, int start, int end) {
        if (start == end) {
            return 1;
        }
        if (vertices.get(start).isEmpty()) {
            return 0;
        }
        int cnt = 0;
        List<Integer> curVertex = vertices.get(start);
        for (int i = 0; i < curVertex.size(); i++) {
            int nextStart = curVertex.get(i);
            List<List<Integer>> nextVertices = getCopy(vertices);
            nextVertices.get(start).remove(i);
            for (List<Integer> vertex : nextVertices) {
                for (int j = 0; j < vertex.size(); j++) {
                    if (vertex.get(j) == start) {
                        vertex.remove(j);
                        break;
                    }
                }
            }
            cnt += cntPaths(nextVertices, nextStart, end);
        }
        return cnt;
    }

    private static List<List<Integer>> getCopy(List<List<Integer>> src) {
        List<List<Integer>> dest = new ArrayList<>(src.size());
        for (List<Integer> srcList : src) {
            List<Integer> destList = new ArrayList<>(srcList);
            dest.add(destList);
        }
        return dest;
    }
}
