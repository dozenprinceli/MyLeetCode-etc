//在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。 
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
// 
//
// 示例 4： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
// 
//
// 示例 5： 
//
// 
//输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// red_edges.length <= 400 
// blue_edges.length <= 400 
// red_edges[i].length == blue_edges[i].length == 2 
// 0 <= red_edges[i][j], blue_edges[i][j] < n 
// 
//
// Related Topics 广度优先搜索 图 👍 244 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
            ++curPath;
            for (Integer idx : head) {
                if (res[idx] == -1) {
                    res[idx] = curPath;
                }
            }
            isRed = !isRed;
        }
        red.clear();
        blue.clear();
        isRed = false;
        curPath = 0;
        head.clear();
        head.add(0);
        while (true) {
            int[][] edges = isRed ? redEdges : blueEdges;
            head = getNextEdge(edges, isRed, head);
            if (head.isEmpty()) {
                break;
            }
            ++curPath;
            for (Integer idx : head) {
                if (res[idx] == -1 || res[idx] > curPath) {
                    res[idx] = curPath;
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
//leetcode submit region end(Prohibit modification and deletion)
