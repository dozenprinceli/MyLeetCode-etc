package string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/30 0:33
 */
public class String15 {
    @Test
    public void testSubstring() {
        String s = "0123456789";
        System.out.println(s.substring(2, 20));
    }

    @Test
    public void test() {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        System.out.println(s1 == s2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String s1 = scan.next();
        map.put(s1, 1);
        String s2 = scan.next();
        map.put(s2, 2);
        System.out.println(map.get(s1));
    }
}
