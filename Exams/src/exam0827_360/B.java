package exam0827_360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dozen Lee<br/>
 * 2022/8/27 15:12
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();
        List<String> subjects = new ArrayList<>(n1);
        List<String>  predicates = new ArrayList<>(n2);
        List<String>  objects = new ArrayList<>(n3);
        for (int i = 0; i < n1; i++) {
            subjects.add(scan.next());
        }
        for (int i = 0; i < n2; i++) {
            predicates.add(scan.next());
        }
        for (int i = 0; i < n3; i++) {
            objects.add(scan.next());
        }
        int m = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < m; i++) {
            String[] words = scan.nextLine().split(" ");
            boolean hasSubject = false;
            boolean isLegal = true;
            boolean hasPredicate = false;
            for (String word : words) {
                if (!hasSubject) {
                    if (!subjects.contains(word)) {
                        isLegal = false;
                        break;
                    } else {
                        hasSubject = true;
                    }
                }
                if (!hasPredicate) {
                    if (predicates.contains(word)) {
                        hasPredicate = true;
                    } else if (objects.contains(word)) {
                        isLegal = false;
                        break;
                    }
                } else {
                    if (predicates.contains(word) || subjects.contains(word)) {
                        isLegal = false;
                        break;
                    }
                }
            }
            if (isLegal) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
