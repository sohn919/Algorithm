import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static char[][] board;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        char temp = board[x][y];
        visit[x][y] = true;
        q.add(new Point(x, y));
        while(!q.isEmpty()) {
            Point o = q.poll();
            for(int i=0; i<4; i++) {
               int nx = o.x + dx[i];
               int ny = o.y + dy[i];
               if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                   continue;
               if(visit[nx][ny] || board[nx][ny] != temp)
                   continue;
               q.add(new Point(nx, ny));
               visit[nx][ny] = true;
            }
        }

    }

    public static void rgBFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        char temp = board[x][y];
        visit[x][y] = true;
        q.add(new Point(x, y));
        while(!q.isEmpty()) {
            Point o = q.poll();
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(temp == 'R' || temp == 'G') {
                    if(board[nx][ny] == 'R' || board[nx][ny] == 'G') {
                        q.add(new Point(nx, ny));
                        visit[nx][ny] = true;
                        continue;
                    }
                }
                if(board[nx][ny] != temp)
                    continue;
                q.add(new Point(nx, ny));
                visit[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        int answer = 0;
        visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    BFS(i, j);
                    answer++;
                }
            }
        }
        int answer2 = 0;
        visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    rgBFS(i, j);
                    answer2++;
                }
            }
        }
        System.out.println(answer + " " + answer2);
    }
}