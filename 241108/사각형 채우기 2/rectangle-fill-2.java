import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[1001];

        dp[0]=0; dp[1] = 1; dp[2] = 3;

        for (int i=3;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2]*2;

        System.out.println(dp[n]);
        
    }
}