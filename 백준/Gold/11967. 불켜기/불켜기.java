import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] lightVisited;
    static ArrayList<Point>[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> lightQ;

    public static void light() {
        boolean flag = false;
        while(!lightQ.isEmpty()) {
            Point o = lightQ.poll();
            for(Point next : arr[o.x][o.y]) {
                if(board[next.x][next.y] == 0) {
                    board[next.x][next.y] = 1;
                    flag = true;
                }
            }
        }
        if(flag) {
            BFS();
        }
    }

    public static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        boolean[][] visit = new boolean[N+1][N+1];
        visit[1][1] = true;
        while(!q.isEmpty()) {
            Point o = q.poll();
            if(!lightVisited[o.x][o.y]) {
                lightQ.add(new Point(o.x, o.y));
                lightVisited[o.x][o.y] = true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if (nx <= 0 || nx > N || ny <= 0 || ny > N)
                    continue;
                if (board[nx][ny] == 0 || visit[nx][ny])
                    continue;
                q.add(new Point(nx, ny));
                visit[nx][ny] = true;
            }
        }
        light();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];
        arr = new ArrayList[N+1][N+1];
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            arr[startX][startY].add(new Point(endX, endY));
        }

        lightQ = new LinkedList<>();
        lightVisited = new boolean[N+1][N+1];
        board[1][1] = 1;
        lightVisited[1][1] = true;
        for(Point cur : arr[1][1]) {
            board[cur.x][cur.y] = 1;
        }
        BFS();

        int answer = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(board[i][j] == 1)
                    answer++;
            }
        }
        System.out.print(answer);
    }
}