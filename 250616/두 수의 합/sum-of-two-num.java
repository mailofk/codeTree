import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap <Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        int sum = 0;

        for (int i=1;i<=n;i++) {
            int remain = k-arr[i];
            if (map.containsKey(remain)) {
                sum += map.get(remain);
                if (remain == arr[i]) sum-=1;
            }
        }
        System.out.println(sum/2);


    }
}