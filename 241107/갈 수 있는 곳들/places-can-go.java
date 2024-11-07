import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static int n,k;
    public static int[][] arr;
    public static boolean[][] visited;
    public static Queue<Point> queue = new LinkedList<>();
    public static int currentCnt = 0;
    
    public static int[] dx = new int[] {0,1,0,-1};
    public static int[] dy = new int[] {1,0,-1,0};

    public static boolean inBound(int x, int y) {
        if (x<0 || y<0 || x>=n || y>=n) return false;
        return true;
    }

    public static boolean canGo(int x, int y) {
        if (inBound(x,y) && visited[x][y] == false && arr[x][y] == 0) return true;
        return false;
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x, y = p.y;

            for (int i=0;i<4;i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    currentCnt++;
                    visited[newX][newY] = true;
                    queue.add(new Point(newX,newY));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<k;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            if (canGo(x,y)) {
                currentCnt++;
                visited[x][y] = true;
                queue.add(new Point(x,y));
                bfs();
            }
        }
        System.out.println(currentCnt);

    }
}