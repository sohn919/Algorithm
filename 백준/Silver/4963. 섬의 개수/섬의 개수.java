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
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Point> q;
    static int N, M;

    public static void BFS(int x, int y) {
        q.add(new Point(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Point o = q.poll();
            for(int i=0; i<8; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(board[nx][ny] == 0 || visited[nx][ny])
                    continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.valueOf(st.nextToken());
            N = Integer.valueOf(st.nextToken());
            if(N == 0 && M == 0)
                break;
            board = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            q = new LinkedList<>();
            int answer = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(board[i][j] == 1 && !visited[i][j])  {
                        BFS(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}