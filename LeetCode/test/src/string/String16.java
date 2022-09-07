package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dozen Lee<br/>
 * 2022/9/7 1:08
 */
public class String16 {
    @Test
    public void test1592() {
        String text = "  this   is  a sentence ";
        System.out.println(reorderSpaces(text));
    }

    public String reorderSpaces(String text) {
        List<String> words = new ArrayList<>();
        int len = text.length();
        int ptr = 0, wordsLen = 0;
        while (ptr < len) {
            if (text.charAt(ptr) == ' ') {
                ptr++;
            } else {
                int begin = ptr;
                while (ptr < len && text.charAt(ptr) != ' ') {
                    ptr++;
                }
                words.add(text.substring(begin, ptr));
                wordsLen += ptr - begin;
            }
        }
        int spaceLen;
        if (words.size() == 1) {
            spaceLen = len - wordsLen;
        } else {
            spaceLen = (len - wordsLen) / (words.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i));
            for (int j = 0; j < spaceLen; j++) {
                sb.append(' ');
            }
        }
        sb.append(words.size() - 1);
        for (int i = 0; i < (len - wordsLen) % (words.size() - 1); i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
