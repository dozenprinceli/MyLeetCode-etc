package codeforces.com.c1718;

import java.util.*;

/**
 * @author Dozen Lee<br/>
 * 2022/8/17 23:47
 */
public class B_FibonacciStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testTimes = scan.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int n = scan.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                insert(arr, scan.nextInt());
            }
            process(arr);
        }
    }

    private static void process(List<Integer> arr) {
        int sum = getSum(arr);
        List<Integer> fibonacci = new ArrayList<>();
        int fiboSum = 0;
        int f1 = 1;
        int f2 = 1;
        while (fiboSum < sum) {
            fibonacci.add(f1);
            fiboSum += f1;
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        if (fiboSum > sum) {
            System.out.println("NO");
            return;
        }
        int last = 0;
        for (int i = fibonacci.size() - 1; i >= 0; i--) {
            if (arr.size() == 0) {
                System.out.println("NO");
                return;
            }
            int biggest = arr.remove(arr.size() - 1);
            int curFibo = fibonacci.get(i);
            if (biggest >= curFibo) {
                biggest -= curFibo;
                if (last != 0) {
                    insert(arr, last);
                }
                last = biggest;
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void insert(List<Integer> arr, int num) {
        if (arr.size() == 0) {
            arr.add(num);
            return;
        }
        int left = 0;
        int right = arr.size() - 1;
        if (arr.get(left) >= num) {
            arr.add(0, num);
            return;
        } else if (arr.get(right) <= num) {
            arr.add(num);
            return;
        }
        while (left < right - 1) {
            int mid = (left + right) / 2;
            int midNum = arr.get(mid);
            if (midNum == num) {
                arr.add(mid, num);
                return;
            }
            if (midNum > num) {
                right = mid;
            } else {
                left = mid;
            }
        }
        arr.add(right, num);
    }

    private static int getSum(List<Integer> arr) {
        int sum = 0;
        for (Integer num :arr) {
            sum += num;
        }
        return sum;
    }
}
