import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point> {
    int x, y, favorite, empty;
    public Point(int x, int y, int favorite, int empty) {
        this.x = x;
        this.y = y;
        this.favorite = favorite;
        this.empty = empty;
    }
    @Override
    public int compareTo(Point o) {
        if(this.favorite != o.favorite)
            return this.favorite - o.favorite;
        if(this.empty != o.empty)
            return this.empty - o.empty;
        if(this.x != o.x)
            return o.x - this.x;
        return o.y - this.y;
    }

}

public class Main {

    static int N, M;
    static int[][] board;
    static int[] num;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Map<Integer, HashSet<Integer>> map;

    // 4방향 BFS 메소드 선언, 위치 별 학생 클래스로 선언, 비어있는 칸도 클래스 안에 같이 선언
    // 4방향 탐색 => 좋아하는 학생이 많은 곳 => 같다면 => 비어있는 칸이 많은 곳 => 같다면 행 , 열

    public static int check(int num, int x, int y) {

        return 0;
    }

    public static Point BFS(int num, int x, int y) {
        Point cur = new Point(x, y, 0, 0);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if(board[nx][ny] == 0) {
                cur.empty = cur.empty + 1;
            }
            if(board[nx][ny] > 0) {
                arr.add(board[nx][ny]);
            }
        }
        for(int a : arr) {
            if(map.get(num).contains(a)) {
                cur.favorite = cur.favorite + 1;
            }
        }
        return cur;
    }

    public static void search(int num) {
        Point o = null;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] > 0)
                    continue;
                else {
                    Point curPoint = BFS(num, i, j);
                    if(o == null)
                        o = curPoint;
                    else if(o.compareTo(curPoint) < 0)
                        o = curPoint;
                }
            }
        }
        board[o.x][o.y] = num;
    }

    public static void solution() {
        int sum = 0;
        // 순서 별로 탐색 ( num 배열을 이용해서 )
        for(int i=0; i<M; i++) {
            search(num[i]);
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                Point o = BFS(board[i][j], i, j);
                if(o.favorite > 1) {
                    sum += Math.pow(10, o.favorite - 1);
                }
                else {
                    sum += o.favorite;
                }
            }
        }
        System.out.print(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = N * N;
        board = new int[N][N];
        num = new int[M];
        map = new HashMap<>();
        // 입력 값 받기 (num 배열은 순서 , hset 은 초기화를 위한 임시)
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            num[i] = temp;
            HashSet<Integer> hset = new HashSet<>();
            for(int j=0; j<4; j++) {
                hset.add(Integer.parseInt(st.nextToken()));
            }
            map.put(temp, hset);
        }
        solution();
    }
}