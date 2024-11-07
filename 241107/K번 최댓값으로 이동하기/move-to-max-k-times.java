import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static int n,k;
    public static int[][] arr;
    public static boolean[][] visited;
    public static Queue<Point> queue = new LinkedList<>();
    public static int currMax = 0;
    public static Point currPoint;

    public static int[] dx = new int[] {1,0,-1,0};
    public static int[] dy = new int[] {0,1,0,-1};

    public static boolean inBound(int x, int y) {
        if (x<0 || y<0 || x>=n || y>=n) return false;
        return true;
    }

    public static boolean canGo(int x, int y, int num) {
        if (inBound(x,y) && visited[x][y] == false && arr[x][y] < num) return true;
        return false;
    }

    public static void bfs(int k) {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x, y = p.y;

            for (int i=0;i<4;i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX,newY, k)) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY));

                    if (currMax < arr[newX][newY]) {
                        currMax = arr[newX][newY];
                        currPoint = new Point(newX, newY);
                        
                    } else if (currMax == arr[newX][newY]) {
                        if (currPoint.x > newX) {
                            currPoint = new Point(newX, newY);
                        } else if (currPoint.x == newX && currPoint.y > newY) {
                            currPoint = new Point(newX, newY);
                        }
                    }

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

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken())-1;
        int startY = Integer.parseInt(st.nextToken())-1;

        for (int i=0;i<k;i++) {
            visited = new boolean[n][n];
            currMax = 0;
            // currPoint = new Point(startX, startY);

            visited[startX][startY] = true;
            queue.add(new Point(startX, startY));
            bfs(arr[startX][startY]);

            if (currMax == 0) break;
            startX = currPoint.x;
            startY = currPoint.y;
            
        }

        System.out.println((startX+1)+" "+(startY+1));
    }
}