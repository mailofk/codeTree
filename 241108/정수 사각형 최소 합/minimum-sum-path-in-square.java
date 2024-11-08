import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[][] arr;
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr=  new int[n][n];
        dp = new int[n][n];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int startX = 0;
        int startY = n-1;
        
        dp[0][n-1] = arr[0][n-1];
        for (int i=n-2;i>=0;i--) {
            dp[0][i] = arr[0][i] + dp[0][i+1];
        }

        for (int i=1;i<n;i++) {
            for (int j=n-1;j>=0;j--) {
                dp[i][j] = arr[i][j] + dp[i-1][j];
            }

            for (int j=n-2;j>=0;j--) {
                dp[i][j] = Math.min(dp[i][j], arr[i][j] + dp[i][j+1]);
            }
        }

        System.out.println(dp[n-1][0]);
    }
}