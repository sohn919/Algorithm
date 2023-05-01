import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, block, day, cnt;
    Point(int x, int y, int block, int day, int cnt) {
        this.x = x;
        this.y = y;
        this.block = block;
        this.day = day;
        this.cnt = cnt;
    }

}

public class Main {

    static int N, M, K;
    static int[][] board;
    static boolean[][][] visited;
    // 블록 체크 , [][] x y 좌표
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    // day = 0 낮 day = 1 밤 낮에만 벽을 부술 수 있음
    public static int BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 0, 1));
        visited[0][0][0] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.x == N-1 && cur.y == M-1)
                return cur.cnt;
            int day = cur.day + 1 == 2 ? 0 : 1;
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                // 낮 ( 벽 부술 수 있음 )
                if(cur.day == 0) {
                    if(board[nx][ny] == 1 && (cur.block == K || visited[cur.block + 1][nx][ny]))
                        continue;
                    if(board[nx][ny] == 1) {
                        visited[cur.block + 1][nx][ny] = true;
                        q.add(new Point(nx, ny, cur.block + 1, day, cur.cnt + 1));
                        continue;
                    }
                    if(visited[cur.block][nx][ny])
                        continue;
                    if(board[nx][ny] == 0) {
                        visited[cur.block][nx][ny] = true;
                        q.add(new Point(nx, ny, cur.block, day, cur.cnt + 1));
                    }
                }
                // 밤
                if(cur.day == 1) {
                    if((board[nx][ny] == 1 && cur.block < K) && !visited[cur.block + 1][nx][ny]) {
                        q.add(new Point(cur.x, cur.y, cur.block, day, cur.cnt + 1));
                        continue;
                    }
                    if(visited[cur.block][nx][ny])
                        continue;
                    if(board[nx][ny] == 0) {
                        visited[cur.block][nx][ny] = true;
                        q.add(new Point(nx, ny, cur.block, day, cur.cnt + 1));
                    }
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
        visited = new boolean[K+1][N][M];
        int answer = BFS();
        System.out.print(answer);
    }
}