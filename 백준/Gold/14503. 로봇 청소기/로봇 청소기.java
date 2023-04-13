import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, dir;
    public Point(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public class Main {

    static int N, M, answer = 0;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> q;

    // 주변 탐색
    public static void search(int x, int y, int dir) {
        boolean flag = true;
        q.add(new Point(x, y, dir));
        while(flag) {
            flag = false;
            Point o = q.poll();
            if (map[o.x][o.y] == 0) {
                answer++;
                map[o.x][o.y] = 2;
            }
            for (int i = 0; i < 4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (map[nx][ny] == 1)
                    continue;
                if (map[nx][ny] == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                clean(o.x, o.y, o.dir);
            else
                flag = back(o.x, o.y, o.dir);
        }
    }

    public static void clean(int x, int y, int dir) {
        int value = 4;
        while(value-- > 0) {
            dir = dir - 1;
            if(dir < 0)
                dir = 3;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            if(map[nx][ny] == 1)
                continue;
            if(map[nx][ny] == 0) {
                q.add(new Point(nx, ny, dir));
                break;
            }
        }
    }

    public static boolean back(int x, int y, int dir) {
        int backDir = (dir + 2) % 4;
        int nx = x + dx[backDir];
        int ny = y + dy[backDir];
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
            return false;
        }
        if(map[nx][ny] == 1) {
            return false;
        }
        q.add(new Point(nx, ny, dir));
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q = new LinkedList<>();
        search(x, y, dir);
        System.out.println(answer);
    }
}