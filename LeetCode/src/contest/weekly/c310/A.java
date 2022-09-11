package contest.weekly.c310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dozen Lee<br/>
 * 2022/9/11 10:29
 */
public class A {
    public int mostFrequentEven(int[] nums) {
        int maxFreq = 0;
        Map<Integer, Integer> numFreq = new HashMap<>();
        List<Integer> maxFreqEven = new ArrayList<>();
        for (int num : nums) {
            if ((num & 1) == 1) {
                continue;
            }
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
            int curFreq = numFreq.get(num);
            if (curFreq == maxFreq) {
                maxFreqEven.add(num);
            } else if (curFreq > maxFreq) {
                maxFreq = curFreq;
                maxFreqEven.clear();
                maxFreqEven.add(num);
            }
        }
        int ans = -1;
        for (int num : maxFreqEven) {
            if (ans == -1) {
                ans = num;
            } else {
                ans = Math.min(ans, num);
            }
        }
        return ans;
    }
}
