import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    static int N, M, answer = 0;
    static int[][] board;
    static ArrayList<Point> virus;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] wall;

    // 벽 3개 조합
    public static void DFS(int L) {
        if(L == 3) {
            answer = Math.max(answer, BFS());
        }
        else {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(wall[i][j])
                        continue;
                    wall[i][j] = true;
                    DFS(L + 1);
                    wall[i][j] = false;
                }
            }
        }
    }

    // 바이러스가 퍼짐
    public static int BFS() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(wall[i][j])
                    visited[i][j] = true;
            }
        }
        for(Point o : virus) {
            // 바이러스를 큐에 넣음
            q.add(o);
        }
        while(!q.isEmpty()) {
            Point o = q.poll();
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(visited[nx][ny])
                    continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }

        int safeArea = 0;
        // 탐색해서 안전 영역 체크
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j])
                    safeArea++;
            }
        }
        return safeArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        wall = new boolean[N][M];
        virus = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    wall[i][j] = true;
                }
                if(temp == 2) {
                    // 바이러스 위치를 확인하고 BFS 돌리기 위해
                    virus.add(new Point(i, j));
                    // 벽 조합할 때 바이러스가 있는 위치는 고르지 않게 하기 위해서 true
                    wall[i][j] = true;
                }
                board[i][j] = temp;
            }
        }
        DFS(0);
        System.out.print(answer);

    }
}