import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int nextInt = 1;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(nextInt++ +" ");
                if (nextInt == 10) nextInt = 1;
            }
            System.out.println();
        }

    }
}