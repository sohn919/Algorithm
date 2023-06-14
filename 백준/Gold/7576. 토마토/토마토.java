import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        Queue<Point> Q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1) {
                    board[i][j] = 1;
                    Q.add(new Point(i, j));
                } else board[i][j] = value;
            }
        }
        int answer = BFS(N, M, board, Q);
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(answer);
    }

    private static int BFS(int N, int M, int[][] board, Queue<Point> Q) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int cnt = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            while(size-- > 0) {
                Point cur = Q.poll();
                for (int i=0; i<4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] != 0) continue;
                    board[nx][ny] = 1;
                    Q.add(new Point(nx, ny));
                }
            }
            cnt++;
        }
        return cnt-1;
    }
}