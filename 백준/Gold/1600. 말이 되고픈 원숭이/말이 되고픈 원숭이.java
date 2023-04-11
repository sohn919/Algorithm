import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, k, cnt;
    public Point(int x, int y, int k, int cnt) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.cnt = cnt;
    }
}

public class Main {

    static int[][] board;
    static int N, M, K;
    static int[] dx = {-1, 0, 1, 0, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {0, 1, 0, -1, -2, -1, 1, 2, 2, 1, -1, -2};

    public static int monkey() {
        boolean[][][] visit = new boolean[N][M][K+1];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 0));
        visit[0][0][0] = true;
        while(!q.isEmpty()) {
            Point o = q.poll();
            int len = 12;
            if(o.x == N-1 && o.y == M-1) {
                return o.cnt;
            }
            if(o.k == K) {
                len = 4;
            }
            for(int i=0; i<len; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 1)
                    continue;
                if(i >= 4) {
                    if(visit[nx][ny][o.k+1])
                        continue;
                    else {
                        q.add(new Point(nx, ny, o.k + 1, o.cnt + 1));
                    }
                    visit[nx][ny][o.k+1] = true;
                }
                else {
                    if(visit[nx][ny][o.k])
                        continue;
                    else
                        q.add(new Point(nx, ny, o.k, o.cnt + 1));
                    visit[nx][ny][o.k] = true;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = monkey();
        System.out.print(answer);
    }
}