package string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/8/23 13:18
 */
public class String04 {
    @Test
    public void test() {
        String s = "  hello world  ";
        List<String> words = Arrays.asList(s.split(" "));
        for (int i = words.size() - 1; i >= 0; i--) {
            if (words.get(i).equals("")) {
                words.remove(i);
            }
        }
        System.out.println(words);
    }
}
