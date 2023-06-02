import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Road {
    int start, ed, dis;
    public Road(int start, int ed, int dis) {
        this.start = start;
        this.ed = ed;
        this.dis = dis;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        List<Road> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            list.add(new Road(start, ed, dis));
        }
        int[] dp = new int[end + 1];
        for(int i=1; i<=end; i++) dp[i] = i;
        for(int i=1; i<=end; i++) {
            for(Road road : list) {
                if(road.start == i-1 && road.ed <= end) {
                    dp[road.ed] = Math.min(dp[i-1] + road.dis, dp[road.ed]);
                }
            }
            dp[i] = Math.min(dp[i-1]+1, dp[i]);
        }
        System.out.println(dp[end]);
    }
}