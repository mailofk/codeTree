import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[][] arr;
    public static int[][] dp;
    public static Queue<Node> queue = new PriorityQueue<>();
    public static int[] dx = new int[] {1,0,-1,0};
    public static int[] dy = new int[] {0,1,0,-1};
    public static int max = Integer.MIN_VALUE;

    public static void findAns() {

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x, y = node.y, num = node.n;

            for (int i=0;i<4;i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newY <0 || newX>=n || newY>=n) continue;
                if (arr[x][y] >= arr[newX][newY]) continue;

                dp[newX][newY] = Math.max(dp[x][y] + 1, dp[newX][newY]);
            }

            max = Math.max(max, dp[x][y]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                queue.add(new Node(i,j,arr[i][j]));
            }
        }

        findAns();
        System.out.println(max+1);

    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int n;

    public Node(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    @Override
    public int compareTo(Node node) {
        return this.n - node.n;
    }
}