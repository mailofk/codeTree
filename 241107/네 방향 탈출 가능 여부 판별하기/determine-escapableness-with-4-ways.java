import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {

    public static int n,m;
    public static boolean[][] visited;
    public static int[][] arr;
    public static Queue<Point> queue = new LinkedList<>();

    public static int[] dx = new int[] {0,1,0,-1};
    public static int[] dy = new int[] {1,0,-1,0};

    public static boolean inBound(int x, int y) {
        if (x<0 || y<0 || x>=n || y>=m) return false;
        return true;
    }

    public static boolean canGo(int x, int y) {
        if (inBound(x,y) && visited[x][y] == false && arr[x][y] == 1) return true;
        return false;
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            for (int i=0;i<4;i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (canGo(newX,newY)) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        visited[0][0] = true;
        queue.add(new Point(0,0));

        bfs();
        if (visited[n-1][m-1]) System.out.println("1");
        else System.out.println("0");
        
    }
}