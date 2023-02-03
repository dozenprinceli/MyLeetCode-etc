package graph;

import org.junit.Test;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2023/2/3 11:36
 */
public class Graph01 {
    @Test
    public void test1129() {
        int n = 3;
        int[][] redEdges = {{0, 1}, {0, 2}};
        int[][] blueEdges = {{1, 0}};
        shortestAlternatingPaths(n, redEdges, blueEdges);
    }

    Map<int[], Boolean> red = new HashMap<>();
    Map<int[], Boolean> blue = new HashMap<>();

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[0] = 0;
        int curPath = 0;
        List<Integer> head = new ArrayList<>();
        head.add(0);
        boolean isRed = true;
        while (true) {
            int[][] edges = isRed ? redEdges : blueEdges;
            head = getNextEdge(edges, isRed, head);
            if (head.isEmpty()) {
                break;
            }
            for (Integer idx : head) {
                if (res[idx] == -1) {
                    res[idx] = ++curPath;
                }
            }
            isRed = !isRed;
        }
        return res;
    }

    List<Integer> getNextEdge(int[][] edges, boolean isRed, List<Integer> heads) {
        Map<int[], Boolean> map = isRed ? red : blue;
        List<Integer> next = new ArrayList<>();
        for (int[] edge : edges) {
            if (map.containsKey(edge) || !heads.contains(edge[0])) {
                continue;
            }
            map.put(edge, true);
            next.add(edge[1]);
        }
        return next;
    }
}
