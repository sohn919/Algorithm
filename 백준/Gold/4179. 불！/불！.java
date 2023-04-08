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
    static char[][] board;
    static Queue<Point> q, fire;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visit;

    public static int BFS() {
        int cnt = q.size();
        int L = 0;
        moveFire();
        while(!q.isEmpty()) {
            if(L == cnt) {
                moveFire();
                L = 0;
                cnt = q.size();
            }
            Point o = q.poll();
            if(o.x == N-1 || o.y == M-1 || o.x == 0 || o.y == 0) {
                return visit[o.x][o.y];
            }
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] > 0)
                    continue;
                if(board[nx][ny] == '#' || board[nx][ny] == 'F')
                    continue;
                visit[nx][ny] = visit[o.x][o.y] + 1;
                q.add(new Point(nx, ny));
            }
            L++;
        }
        return -1;
    }

    public static void moveFire() {
        int cnt = fire.size();
        int L = 0;
        while(L++ < cnt) {
            Point o = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(board[nx][ny] == '#' || board[nx][ny] == 'F')
                    continue;
                fire.add(new Point(nx, ny));
                board[nx][ny] = 'F';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visit = new int[N][M];
        q = new LinkedList<>();
        fire = new LinkedList<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == 'J') {
                    visit[i][j] = 1;
                    q.add(new Point(i, j));
                }
                if(s.charAt(j) == 'F') {
                    fire.add(new Point(i, j));
                }
                board[i][j] = s.charAt(j);
            }
        }
        int answer = BFS();
        if(answer > 0) {
            System.out.println(answer);
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
    }
}