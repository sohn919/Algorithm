import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y, dir;
    Point(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {
    static HashMap<Integer, String> Dir;
    static Deque<Point> dq = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, count;
    static int[][] board;

    public static void move() {
        dq.add(new Point(1, 1, 1));
        count = 0;
        while(true) {
            if(Dir.containsKey(count)) {
                dirMove(Dir.get(count));
            }
            count++;
            Point curHead = dq.peekFirst();
            int nx = curHead.x + dx[curHead.dir];
            int ny = curHead.y + dy[curHead.dir];
            if(nx <= 0 || nx > N || ny <= 0 || ny > N)
                break;
            if(dq.contains(new Point(nx, ny, curHead.dir)))
                break;
            if(board[nx][ny] == 1) {
                board[nx][ny] = 0;
                dq.addFirst(new Point(nx, ny, curHead.dir));
                continue;
            }
            dq.addFirst(new Point(nx, ny, curHead.dir));
            dq.pollLast();
        }
    }

    // 뱀 머리 돌려주기
    public static void dirMove(String s) {
        // 돌리 머리 붙이기
        Point head = dq.pollFirst();
        
        if(s.equals("L")) {
            int nextDir = head.dir - 1;
            if(nextDir < 0)
                nextDir = 3;
            dq.addFirst(new Point(head.x, head.y, nextDir));
        }
        else {
            int nextDir = head.dir + 1;
            if(nextDir > 3)
                nextDir = 0;
            dq.addFirst(new Point(head.x, head.y, nextDir));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int appleN = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        for(int i=0; i<appleN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }
        int snackDir = Integer.parseInt(br.readLine());
        Dir = new HashMap<>();
        for(int i=0; i<snackDir; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            Dir.put(time, direction);
        }
        move();
        System.out.println(count);
    }
}