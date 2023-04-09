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
    static int[][] board;
    static Queue<Point> q;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int goalX, goalY, L;

    public static int BFS() {
        while(!q.isEmpty()) {
            Point o = q.poll();
            if(o.x == goalX && o.y == goalY) {
                return board[goalX][goalY];
            }
            for(int i=0; i<8; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(nx < 0 || nx >= L || ny < 0 || ny >= L)
                    continue;
                if(board[nx][ny] > 0)
                    continue;
                q.add(new Point(nx, ny));
                board[nx][ny] = board[o.x][o.y] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            L = Integer.parseInt(br.readLine());
            board = new int[L][L];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int knightX = Integer.parseInt(st.nextToken());
            int knightY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            q.add(new Point(knightX, knightY));
            int answer = BFS();
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}