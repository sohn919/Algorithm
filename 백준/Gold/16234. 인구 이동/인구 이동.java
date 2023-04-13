import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R, answer = 0;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> unionHuman;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        humanMove();
        System.out.print(answer);
    }

    // 인구 이동 (완전 탐색)
    public static void humanMove() {
        boolean flag = true;
        while(flag) {
            flag = false;
            visit = new boolean[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!visit[i][j]) {
                        int sum = BFS(i, j);
                        // 인구 이동이 있으면 flag = true
                        if(unionHuman.size() > 1) {
                            HumanAVG(sum);
                            flag = true;
                        }
                    }
                }
            }
            if(flag)
                answer++;
        }
    }

    // 연합 체크 (BFS)
    public static int BFS(int x, int y) {
        int sum = map[x][y];
        Queue<Point> q = new LinkedList<>();
        unionHuman = new LinkedList<>();
        q.add(new Point(x, y));
        unionHuman.add(new Point(x, y));
        visit[x][y] = true;
        while(!q.isEmpty()) {
            Point o = q.poll();
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if(visit[nx][ny])
                    continue;
                int temp = Math.abs(map[o.x][o.y] - map[nx][ny]);
                if(temp >= L && temp <= R) {
                    q.add(new Point(nx, ny));
                    unionHuman.add(new Point(nx, ny));
                    sum += map[nx][ny];
                    visit[nx][ny] = true;
                }
            }
        }
        return sum;
    }

    //
    public static void HumanAVG(int sum) {
        int avg = sum / unionHuman.size();
        for(Point o : unionHuman) {
            map[o.x][o.y] = avg;
        }
    }

}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}