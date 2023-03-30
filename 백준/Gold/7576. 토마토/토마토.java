import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] isvisit;
    static Queue<Point> q;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void BFS() {
        while(!q.isEmpty()) {
            Point o = q.poll();
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N || isvisit[nx][ny] || board[nx][ny] != 0)
                    continue;
                q.add(new Point(nx, ny));
                isvisit[nx][ny] = true;
                board[nx][ny] = board[o.x][o.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        board = new int[M][N];
        isvisit = new boolean[M][N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        q = new LinkedList<>();

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == 1) {
                    q.add(new Point(i, j));
                    isvisit[i][j] = true;
                }
            }
        }
        BFS();
        int answer = 0;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                answer = Math.max(answer, board[i][j]);
            }
        }
        System.out.print(answer - 1);


    }
}