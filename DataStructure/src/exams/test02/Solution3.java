package exams.test02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/13 17:43
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        Queue<Integer> pokes = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            pokes.offer(nums[i]);
            Integer poll = pokes.poll();
            pokes.offer(poll);
            poll = pokes.poll();
            pokes.offer(poll);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : pokes) {
            sb.insert(0, "" + num + " ");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        System.out.println(sb);
    }
}
