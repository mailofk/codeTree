import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[][] arr;
    public static int[][] dp;

    //위나 왼쪽에서 온것중에 최댓값 넣어버리기
    public static void initialize() {
        dp[0][0] = arr[0][0];

        for (int i=1;i<n;i++) {
            dp[0][i] = Math.min(dp[0][i-1], arr[0][i]);
        }

        for (int i=1;i<n;i++) {
            dp[i][0] = Math.min(dp[i-1][0], arr[i][0]);
        }

        for (int i=1;i<n;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        if (n>=2)
            dp[n-1][n-1] = Math.max(dp[n-1][n-2], dp[n-2][n-1]);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        dp = new int[n][n];
        
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        initialize();
        if (n==1) System.out.println(arr[0][0]);
        else
            System.out.println(dp[n-1][n-1]);

    }
}