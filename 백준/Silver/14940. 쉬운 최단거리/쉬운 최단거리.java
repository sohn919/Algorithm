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
    static int[][] board, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void BFS(Queue<Point> q) {
        boolean[][] visited = new boolean[N][M];
        visited[q.peek().x][q.peek().y] = true;
        while(!q.isEmpty()) {
            Point o = q.poll();
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(visited[nx][ny] || board[nx][ny] == 0)
                    continue;
                answer[nx][ny] = answer[o.x][o.y] + 1;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        answer = new int[N][M];
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }
        BFS(q);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 2) {
                    sb.append(0 + " ");
                    continue;
                }
                if(answer[i][j] == 0 && board[i][j] > 0) {
                    sb.append(-1 + " ");
                    continue;
                }
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}