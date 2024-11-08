import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static long[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[20];

        dp[0] = 1; dp[1] = 1; dp[2] = 2; 
        for (int i=3;i<=n;i++) {
            // dp[i] = dp[i-1]*2 + dp[i-2];
            // for (int j = 1;j<i-1;j++) {
            for (int j=0;j<=i-1;j++) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }      

        System.out.println(dp[n]);                                                       
    }
}