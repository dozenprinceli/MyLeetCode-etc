package array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dozen Lee<br/>
 * 2022/8/18 2:38
 */
public class Array01 {
    @Test
    public void test() {
        int[] nums = new int[]{};
        int ans = 0;
        int idx = 0;
        while (idx < nums.length && nums[idx] == nums[0]) {
            ans++;
            idx++;
        }
        if (idx == nums.length) {
            System.out.println("Get to this judgement");
        } else {
            System.out.println("Cannot get to this line");
        }
    }

    @Test
    public void test1224() {
        int[] arr = new int[]{1, 1, 1, 2, 2, 2};
        System.out.println(new Array01().maxEqualFreq(arr));
    }

    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freqCnt = new HashMap<>();
        Map<Integer, Integer> numFreq = new HashMap<>();
        int ans = 0;
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            // 更新之前的freqCnt值(freqCnt[curNum]-1)
            if (numFreq.containsKey(curNum)) {
                int curNumFreq = numFreq.get(curNum);
                freqCnt.put(curNumFreq, freqCnt.get(curNumFreq) - 1);
            }
            // 更新当前频数
            numFreq.put(curNum, numFreq.getOrDefault(curNum, 0) + 1);
            // 更新新的freqCnt值(freqCnt[curNum]+1)
            freqCnt.put(numFreq.get(curNum), freqCnt.getOrDefault(numFreq.get(curNum), 0) + 1);
            // 更新maxFreq值
            maxFreq = Math.max(maxFreq, numFreq.get(curNum));
            // 判断是否符合
            if (isFit(freqCnt, maxFreq, i + 1)) {
                ans = i + 1;
            }
        }
        return ans;
    }

    private boolean isFit(Map<Integer, Integer> freqCnt, int maxFreq, int n) {
        return maxFreq == 1 ||
                freqCnt.get(1) == 1 && freqCnt.get(maxFreq) * maxFreq + 1 == n ||
                freqCnt.get(maxFreq) == 1 && freqCnt.get(maxFreq - 1) * (maxFreq - 1) + maxFreq == n;
    }
}
