import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static boolean[][] visited;
    public static int[][] arr;

    public static int[] dx = new int[] {0,1,0,-1};
    public static int[] dy = new int[] {1,0,-1,0};

    public static int maxBlockCnt = 0;
    public static int explodedBlock = 0;
    public static boolean hasExceeded = false;
    public static int cnt = 0;

    public static boolean inBound(int x, int y) {
        if (x<0 || y<0 || x>=n || y>=n) return false;
        return true;
    }

    public static boolean canGo(int x, int y, int before) {
        if (inBound(x,y) && arr[x][y]==before && visited[x][y] == false) return true;
        return false;
    }

    public static void calc(int x, int y) {
        if (cnt >=4) {
            hasExceeded = true;
        }

        for (int i=0;i<4;i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (canGo(newX, newY, arr[x][y])) {
                visited[newX][newY] = true;
                cnt++;
                calc(newX, newY);
            }
        }

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (canGo(i,j,arr[i][j])) {
                    hasExceeded = false;
                    cnt = 1;
                    visited[i][j] = true;
                    calc(i,j);
                    if (hasExceeded) explodedBlock++;
                    maxBlockCnt = Math.max(maxBlockCnt, cnt);
                }
            }
        }        

        System.out.println(explodedBlock+" "+maxBlockCnt);

    }
}