import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, block, cnt;
    public Point(int x, int y, int block, int cnt) {
        this.x = x;
        this.y = y;
        this.block = block;
        this.cnt = cnt;
    }
}

public class Main {

    static int[][] board;
    static int N, M, K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 1));
        boolean[][][] visit = new boolean[N][M][K+1];
        visit[0][0][0] = true;
        while(!q.isEmpty()) {
            Point o = q.poll();
            if(o.x == N-1 && o.y == M-1)
                return o.cnt;
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(board[nx][ny] == 1 && o.block == K)
                    continue;
                if(board[nx][ny] == 1) {
                    if(visit[nx][ny][o.block+1])
                        continue;
                    else
                        q.add(new Point(nx, ny, o.block + 1, o.cnt + 1));
                    visit[nx][ny][o.block+1] = true;
                }
                else {
                    if(visit[nx][ny][o.block])
                        continue;
                    q.add(new Point(nx, ny, o.block, o.cnt + 1));
                    visit[nx][ny][o.block] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        int answer = BFS();
        System.out.print(answer);
    }
}