package common;

import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/9/11 12:08
 */
public class ArrayInsertion {
    // 二分插入, 从小到大有序
    private void insert(List<Integer> list, int num) {
        if (list.isEmpty() || list.get(list.size() - 1) <= num) {
            list.add(num);
            return;
        }
        if (list.get(0) >= num) {
            list.add(0, num);
            return;
        }
        int left = 0, right = list.size() - 1;
        while (left < right - 1) {
            int mid = (left + right) >> 1;
            int midNum = list.get(mid);
            if (midNum == num) {
                list.add(mid, num);
                return;
            }
            if (midNum < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        list.add(right, num);
    }
}
