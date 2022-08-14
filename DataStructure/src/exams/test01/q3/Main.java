package exams.test01.q3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/7/28 21:51
 */
public class Main {
    public static void main(String[] args) {
        int i = findGreaterNum(3120095);
        System.out.println(i);
    }

    public static int findGreaterNum (int N) {
        int pow = 1;
        List<Integer> digitsN = new ArrayList<>();
        while (N / pow > 0) {
            int digit = N % (pow * 10) / pow;
            digitsN.add(0, digit);
            pow *= 10;
        }
        boolean flag = false;
        int helper = -1;
        for (int i = digitsN.size() - 2; i >= 0; i--) {
            if (digitsN.get(i) < digitsN.get(i + 1)) {
                for (int j = digitsN.size() - 1; j > i; j--) {
                    if (digitsN.get(j) > digitsN.get(i)) {
                        int iNum = digitsN.get(i);
                        int jNum = digitsN.get(j);
                        digitsN.set(i, jNum);
                        digitsN.set(j, iNum);
                        flag = true;
                        helper = i;
                        break;
                    }
                }
                break;
            }
        }
        if (!flag) {
            return -1;
        } else {
            int res = 0;
            int size = digitsN.size();
            for (int k = helper + 1; k <= (size + helper) / 2; k++) {
                int oppo = size + helper - k;
                int temp = digitsN.get(k);
                digitsN.set(k, digitsN.get(oppo));
                digitsN.set(oppo, temp);
            }
            for (int i = size - 1; i >= 0; i--) {
                pow = ((int) Math.pow(10, size - i - 1));
                res += digitsN.get(i) * pow;
            }
            return res;
        }
    }
}
