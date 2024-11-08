import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[1001];

        dp[1] = 0; dp[2] = 1; dp[3] = 1;
        for (int i=4;i<=n;i++)
            dp[n] = (dp[n-2] + dp[n-3])%10007;

        System.out.println(dp[n]);

        

    }
}