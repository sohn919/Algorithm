import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        System.out.print(BFS());
    }

    public static long BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 1));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.num == M) {
                return cur.cnt;
            }
            long next = 0;
            for(int i=0; i<2; i++) {
                if(i == 0)
                    next = cur.num * 10 + 1;
                if(i == 1)
                    next = cur.num * 2;
                if(next > M)
                    continue;
                q.add(new Point(next, cur.cnt + 1));
            }
        }
        return -1;
    }
}

class Point {
    long num, cnt;
    public Point(long num, long cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}