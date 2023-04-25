import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, bridge;
    Point(int x, int y, int bridge) {
        this.x = x;
        this.y = y;
        this.bridge = bridge;
    }
}

public class Main {

    static int N, answer = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][] visitIsland;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 섬 번호 지정
    public static void searchIsland(int x, int y, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if(visitIsland[nx][ny] || board[nx][ny] == 0)
                    continue;
                q.add(new Point(nx, ny, 0));
                visitIsland[nx][ny] = true;
                board[nx][ny] = cnt;
            }
        }
    }

    // 다리 연결 x, y 섬 번호
    public static int searchBridge(int x, int y, int cnt) {
        int value = Integer.MAX_VALUE;
        int[][] bridgeBoard = new int[N][N];
        boolean[][] visitBridge = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        visitBridge[x][y] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if(board[nx][ny] != 0 && board[nx][ny] != cnt) {
                    value = Math.min(value, cur.bridge);
                    continue;
                }
                if(visitBridge[nx][ny]) {
                    if(board[nx][ny] == 0 && bridgeBoard[nx][ny] > cur.bridge + 1) {
                        q.add(new Point(nx, ny, cur.bridge + 1));
                        bridgeBoard[nx][ny] = cur.bridge + 1;
                        continue;
                    }
                    continue;
                }
                if(board[nx][ny] == cnt) {
                    q.add(new Point(nx, ny, 0));
                    bridgeBoard[nx][ny] = 0;
                }
                if(board[nx][ny] == 0) {
                    q.add(new Point(nx, ny, cur.bridge + 1));
                    bridgeBoard[nx][ny] = cur.bridge + 1;
                }
                visitBridge[nx][ny] = true;
            }
        }
    if(value == Integer.MAX_VALUE)
        return 0;
    else
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 지정
        visitIsland = new boolean[N][N];
        int cnt = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visitIsland[i][j])
                    continue;
                if(board[i][j] == 1) {
                    visitIsland[i][j] = true;
                    board[i][j] = cnt;
                    searchIsland(i, j, cnt);
                    cnt++;
                }
            }
        }

        // 다리 연결
        cnt = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == cnt) {
                    answer = Math.min(answer, searchBridge(i, j, cnt));
                    cnt++;
                }
            }
        }
        System.out.print(answer);

    }
}