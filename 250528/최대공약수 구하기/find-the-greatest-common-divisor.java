import java.util.Scanner;
import java.util.*;
//최대공약수 구하기

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        System.out.println(bcd(n,m));
    }

    public static int bcd(int a, int b) {
        if (b == 0) return a;
        return bcd(b/a, b%a);
    }
}