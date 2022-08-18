package string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2022/8/16 0:35
 */
public class String01 {
    public static void main(String[] args) {
        String[] strs = new String[5];
        System.out.println(strs[2]);
    }

    @Test
    public void test() {
        String s = "10011";
        System.out.println(Arrays.toString(s.split("")));
    }

}
