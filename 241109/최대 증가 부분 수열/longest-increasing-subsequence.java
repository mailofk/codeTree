import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static final int MIN_NUMBER = Integer.MIN_VALUE;
    public static int max = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // for (int i=1;i<n;i++)
            // dp[i] = MIN_NUMBER;
        
        for (int i=1;i<n;i++) {
            for (int j=0;j<i;j++) {
                // if (dp[j] == MIN_NUMBER) continue;
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i=0;i<n;i++)
            max = Math.max(max, dp[i]);

        System.out.println(max + 1);

    }
}