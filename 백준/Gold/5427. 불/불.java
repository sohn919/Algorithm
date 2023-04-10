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

    static char[][] board;
    static int[][] visit;
    static Queue<Point> Q, fireQ;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int move() {
        int L = Q.size();
        while(true) {
            moveFire();
            while(L-- > 0) {
                Point o = Q.poll();
                if(o.x == 0 || o.x == N-1 || o.y == 0 || o.y == M-1)
                    return visit[o.x][o.y];
                for(int i=0; i<4; i++) {
                    int nx = o.x + dx[i];
                    int ny = o.y + dy[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                        continue;
                    if(board[nx][ny] == '#' || board[nx][ny] == '*')
                        continue;
                    if(visit[nx][ny] > 0)
                        continue;
                    Q.add(new Point(nx, ny));
                    visit[nx][ny] = visit[o.x][o.y] + 1;
                }
            }
            L = Q.size();
            if(Q.size() == 0)
                return -1;
        }
    }

    public static void moveFire() {
        int L = fireQ.size();
        while(L-- > 0) {
            Point o = fireQ.poll();
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(board[nx][ny] == '#' || board[nx][ny] == '*')
                    continue;
                fireQ.add(new Point(nx, ny));
                board[nx][ny] = '*';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(L-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            board = new char[N][M];
            visit = new int[N][M];
            Q = new LinkedList<>();
            fireQ = new LinkedList<>();
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<M; j++) {
                    if(s.charAt(j) == '@') {
                        Q.add(new Point(i, j));
                        visit[i][j] = 1;
                    }
                    if(s.charAt(j) == '*') {
                        fireQ.add(new Point(i, j));
                    }
                    board[i][j] = s.charAt(j);
                }
            }
            int answer = move();
            if(answer > 0)
                sb.append(answer).append("\n");
            else
                sb.append("IMPOSSIBLE").append("\n");
//            for(int i=0; i<N; i++) {
//                for(int j=0; j<M; j++) {
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println();
//            }

        }
        System.out.print(sb);
    }
}