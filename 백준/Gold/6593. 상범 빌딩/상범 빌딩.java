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
    static char[][][] arr;
    static int[][][] visit;
    static Queue<Point> q;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int L, N, M, goalH, goalX, goalY;

    public static int BFS() {
        while(!q.isEmpty()) {
            Point o = q.poll();
            if(o.h == goalH && o.x == goalX && o.y == goalY)
                return visit[o.h][o.x][o.y];
            for(int i=0; i<6; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                int nh = o.h + dh[i];
                if(nh < 0 || nh >= L)
                    continue;
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(visit[nh][nx][ny] > 0 || arr[nh][nx][ny] == '#')
                    continue;
                visit[nh][nx][ny] = visit[o.h][o.x][o.y] + 1;
                q.add(new Point(nh, nx, ny));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (L == 0 && N == 0 && M == 0)
                break;
            arr = new char[L][N][M];
            visit = new int[L][N][M];
            q = new LinkedList<>();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < N; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < M; k++) {
                        if(s.charAt(k) == 'S') {
                            q.add(new Point(i, j, k));
                            visit[i][j][k] = 1;
                        }
                        if(s.charAt(k) == 'E') {
                            goalH = i;
                            goalX = j;
                            goalY = k;
                        }
                        arr[i][j][k] = s.charAt(k);
                    }
                }
                br.readLine();
            }
            int answer = BFS();
            if(answer > 0) {
                sb.append("Escaped in " + (answer - 1) + " minute(s).").append("\n");
            }
            else {
                sb.append("Trapped!").append("\n");
            }
        }
        System.out.print(sb);
    }
}