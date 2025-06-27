import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap <Integer, List<Integer[]> > map = new HashMap<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int hap = arr[i] + arr[j];
                Integer[] pos = {i,j};
                if (map.containsKey(hap))  {
                    List<Integer[]> list = map.get(hap);
                    list.add(pos);
                    map.put(hap, list);
                }
                else {
                    List<Integer[]> list = new ArrayList<>();
                    list.add(pos);
                    map.put(hap, list);
                } 
            }
        }

        int total = 0;
        for (int i=0;i<n;i++) {
            int remain = k - arr[i];
            if (map.containsKey(remain)) {
                List<Integer[]> list = map.get(remain);
                for (Integer[] check : list) {
                    if (check[1] >= i) continue;
                    total+=1;
                }
            }
        }

        System.out.println(total);
    }
}