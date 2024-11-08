import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[46];

        dp[1]=1; 
        dp[2]=1;
        for (int i=3;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2];

        System.out.println(dp[n]);
    }
}