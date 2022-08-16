package codeforces.com.c1719;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Dozen Lee<br/>
 * 2022/8/17 1:27
 */
public class Test {
    public static void main(String[] args) {
        int testTimes = 100;
        Random rand = new Random();
        for (int i = 0; i < testTimes; i++) {
            int size = rand.nextInt(10) + 5;
            List<Integer> lst = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                lst.add(j + 1);
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                int randomIndex = rand.nextInt(size - j);
                sb.append(lst.remove(randomIndex)).append(" ");
            }
            int randI = rand.nextInt(size) + 1;
            int randK = rand.nextInt(20);
            System.out.println(size + " " + 1);
            System.out.println(sb);
            System.out.println(randI + " " + randK);
        }
    }
}
