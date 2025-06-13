import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap <Integer, Integer> map = new HashMap<>(); 

        // Please write your code here.
        for (int i=0;i<n;i++) {
            String s = sc.nextLine();
            String[] full = s.split(" ");
            String cmd = full[0];

            int key = Integer.parseInt(full[1]);
            if (cmd.equals("add")) {
             int value = Integer.parseInt(full[2]);
             map.put(key,value);
            } else if (cmd.equals("find")) {
                if (!map.containsKey(key)) System.out.println("None");
                else System.out.println(map.get(key));
            } else {
                map.remove(key);
            }


        }

    }
}