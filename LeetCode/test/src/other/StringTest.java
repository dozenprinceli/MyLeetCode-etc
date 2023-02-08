package other;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dozen Lee<br/>
 * 2023/2/8 0:20
 */
public class StringTest {
    @Test
    public void testSplit() {
        String str = "/aa/bbb/cc/ddd";
        String[] split = str.split("/");
        System.out.println(Arrays.toString(split));
    }
}
