package test0925;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/9/25 9:27
 */
public class F {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Vertex[] chart = new Vertex[n + 1];
        for (int mi = 0; mi < m; mi++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int fee = scan.nextInt();
            float formatFee = 1 / (1 - (float)(fee) / 100);
            putIn(chart, v1, v2, formatFee);
            putIn(chart, v2, v1, formatFee);
        }
        int start = scan.nextInt();
        int end = scan.nextInt();

        double[] dist = new double[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] path = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == start) {
                dist[i] = 0;
                visited[i] = true;
                path[i] = -1;
                continue;
            }
            dist[i] = chart[start].next.getOrDefault(i, Double.MAX_VALUE);
            if (chart[start].next.containsKey(i)) {
                path[i] = 1;
            } else {
                path[i] = -1;
            }
        }

        while (!isEnd(visited)) {
            int minIdx = -1;
            double minDist = Float.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minIdx = i;
                    minDist = dist[i];
                }
            }
            visited[minIdx] = true;
            Vertex curV = chart[minIdx];
            for (Map.Entry<Integer, Double> nextInfo : curV.next.entrySet()) {
                int nextNo = nextInfo.getKey();
                if (nextInfo.getValue() * dist[minIdx] < dist[nextNo]) {
                    dist[nextNo] = nextInfo.getValue() * dist[minIdx];
                    path[nextNo] = minIdx;
                }
            }
        }

        double fee = 100.0D;
        int cur = end;
        while (cur != start) {
            fee *= chart[cur].next.get(path[cur]);
            cur = path[cur];
        }
        System.out.println((float)fee);
    }

    private static boolean isEnd(boolean[] visit) {
        for (int i = 1; i < visit.length; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }

    private static void putIn(Vertex[] chart, int v1, int v2, double fee) {
        if (chart[v1] != null) {
            chart[v1].next.put(v2, fee);
        } else {
            Vertex v = new Vertex();
            v.next.put(v2, fee);
            chart[v1] = v;
        }
    }

    private static class Vertex {
        Vertex() {
            next = new HashMap<>();
        }

        Map<Integer, Double> next;
    }
}
