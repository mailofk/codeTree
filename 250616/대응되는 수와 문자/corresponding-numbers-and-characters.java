import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap <String, String> map = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n + 1];
        String[] finds = new String[m + 1];
        
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            map.put(String.valueOf(i), words[i]);
            map.put(words[i],String.valueOf(i));
        }

        for (int i = 1; i <= m; i++) {
            finds[i] = sc.next();
            System.out.println(map.get(finds[i]));
        }

        

    }
}