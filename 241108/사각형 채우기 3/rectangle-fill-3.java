import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[] dp;
    public static final int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[1001];
        dp[0]=1; dp[1]=2; dp[2] = 7;

        for (int i=3;i<=n;i++) {
            dp[i] = (dp[i-1]*2 + dp[i-2]*3)%MOD;
            for (int j = i-3;j>=0;j--) {
                dp[i] = (dp[i] + (dp[j]*2)%MOD)%MOD;
            }
        }

        System.out.println(dp[n]);
    }
}