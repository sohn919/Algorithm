import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Point> home, chicken;
    static boolean[] check;

    public static void combi(int L, int a) {
        if(L == M) {
            answer = Math.min(answer, solution());
        }
        for(int i=a; i<chicken.size(); i++) {
            check[i] = true;
            combi(L+1, i+1);
            check[i] = false;
        }
    }

    public static int solution() {
        int sum = 0;
        int[] homeMin = new int[home.size()];
        Arrays.fill(homeMin, Integer.MAX_VALUE);
        for(int i=0; i<check.length; i++) {
            if(check[i]) {
                int cnt = 0;
                Point curChicken = chicken.get(i);
                for(Point o : home) {
                    homeMin[cnt] = Math.min(Math.abs(curChicken.x - o.x) + Math.abs(curChicken.y - o.y), homeMin[cnt]);
                    cnt++;
                }
            }
        }
        for(int i=0; i<homeMin.length; i++) {
            sum += homeMin[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    home.add(new Point(i, j));
                }
                if(temp == 2) {
                    chicken.add(new Point(i, j));
                }
                map[i][j] = temp;
            }
        }
        check = new boolean[chicken.size()];
        combi(0, 0);
        System.out.print(answer);
    }
}