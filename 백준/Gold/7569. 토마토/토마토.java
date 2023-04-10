import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int h, x, y;
    public Point(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][][] board;
    static int N, M, H;
    static Queue<Point> q;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void tomato() {
        while(!q.isEmpty()) {
            Point o = q.poll();
            for(int i=0; i<6; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                int nh = o.h + dh[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || nh < 0 || nh >= H) {
                    continue;
                }
                if(board[nh][nx][ny] == -1 || board[nh][nx][ny] > 0)
                    continue;
                q.add(new Point(nh, nx, ny));
                board[nh][nx][ny] = board[o.h][o.x][o.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][N][M];
        q = new LinkedList<>();
        for(int k=0; k<H; k++) {
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp == 1) {
                        q.add(new Point(k, i, j));
                    }
                    board[k][i][j] = temp;
                }
            }
        }
        tomato();
        int answer = 0;
        for(int k=0; k<H; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(board[k][i][j] == 0) {
                        System.out.print("-1");
                        return;
                    }
                    answer = Math.max(answer, board[k][i][j]);
                }
            }
        }
        System.out.print(answer - 1);
    }
}