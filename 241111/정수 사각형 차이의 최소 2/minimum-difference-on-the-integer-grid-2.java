import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static int n;
    public static int[][] arr;
    public static Point[][] dp;

    // 최대 , 최소가 비슷하게 

    public static int currMinDiff = 0;

    public static void initialize() {
        int cmax = 0;
        int cmin = 0;
        dp[0][0] = new Point(arr[0][0], arr[0][0]);

        for (int i=1;i<n;i++) {
            cmax = Math.max(dp[0][i-1].x, arr[0][i]);
            cmin = Math.min(dp[0][i-1].y, arr[0][i]);
            dp[0][i] = new Point(cmax, cmin);
        }

        for (int i=1;i<n;i++) {
            cmax = Math.max(dp[i-1][0].x, arr[i][0]);
            cmin = Math.min(dp[i-1][0].y, arr[i][0]);
            dp[i][0] = new Point(cmax, cmin);
        }

    }

    public static Point getMinDiff(Point p1, Point p2, int check) {
        int firstMax = Math.max(p1.x, check);
        int firstMin = Math.min(p1.y, check);
        int secondMax = Math.max(p2.x, check);
        int secondMin = Math.min(p2.y, check);

        if (firstMax - firstMin < secondMax - secondMin) return new Point(firstMax,firstMin);
        else return new Point(secondMax, secondMin);
    }

    public static void findAnswer() {
        for (int i=1;i<n;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = new Point(getMinDiff(dp[i][j-1], dp[i-1][j], arr[i][j]));
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Point[n][n];
        StringTokenizer st;

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) 
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        initialize();
        findAnswer();

        // for (int i=0;i<n;i++) {
        //     for (int j=0;j<n;j++) {
        //         System.out.print(dp[i][j].x +" and "+dp[i][j].y + " / ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[n-1][n-1].x - dp[n-1][n-1].y);

    }
}