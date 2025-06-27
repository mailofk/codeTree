import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap <Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i=0;i<n;i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i],1);
            else map.put(arr[i], map.get(arr[i]) + 1);
        }

        int total = 0;
        for (int i=0;i<n;i++) {
            if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])-1);
            for (int j=0;j<i;j++) {
                if (map.containsKey(k-arr[i]-arr[j])) {
                    total += map.get(k-arr[i]-arr[j]);
                }
            }
        }

        

        System.out.println(total);
    }
}