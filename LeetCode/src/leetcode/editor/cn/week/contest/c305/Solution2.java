package leetcode.editor.cn.week.contest.c305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dozen Lee<br/>
 * 2022/8/7 10:59
 */
public class Solution2 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer> nodes = new ArrayList<>();
        List<Integer> restrictedNodes = Arrays.stream(restricted).boxed().collect(Collectors.toList());
        nodes.add(0);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < edges.length; ++i) {
                int num0 = edges[i][0];
                int num1 = edges[i][1];
                boolean judge0 = nodes.contains(num0);
                boolean judge1 = nodes.contains(num1);
                if ((judge0 || judge1) && (!restrictedNodes.contains(num0) && !restrictedNodes.contains(num1))) {
                    if (!judge0) {
                        nodes.add(num0);
                        flag = true;
                    } else if (!judge1) {
                        nodes.add(num1);
                        flag = true;
                    }
                }
            }
        }
        return nodes.size();
    }
}
