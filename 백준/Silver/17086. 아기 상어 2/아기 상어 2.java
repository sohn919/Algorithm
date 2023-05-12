import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, cnt;
    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {

    static int N, M;
    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static int forceSearch(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i=0; i<8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(visited[nx][ny])
                    continue;
                if(board[nx][ny] == 1) {
                    return cur.cnt + 1;
                }
                q.add(new Point(nx, ny, cur.cnt + 1));
                visited[nx][ny] = true;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 0) {
                    answer = Math.max(forceSearch(i, j), answer);
                }
            }
        }
        System.out.println(answer);
    }
}
