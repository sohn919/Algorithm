import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int s, e, cost;
    public Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        ArrayList<Edge> arr = new ArrayList<>();

        long[] dis = new long[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            arr.add(new Edge(s, e, cost));
        }

        dis[1] = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M; j++) {
                Edge edge = arr.get(j);
                int cur_s = edge.s;
                int cur_e = edge.e;
                int cur_cost = edge.cost;
                if(dis[cur_s] != Integer.MAX_VALUE && dis[cur_e] > dis[cur_s] + cur_cost) {
                    dis[cur_e] = dis[cur_s] + cur_cost;
                }
            }
        }
        for(int j=0; j<M; j++) {
            Edge edge = arr.get(j);
            int cur_s = edge.s;
            int cur_e = edge.e;
            int cur_cost = edge.cost;
            if(dis[cur_s] != Integer.MAX_VALUE && dis[cur_e] > dis[cur_s] + cur_cost) {
                dis[cur_e] = dis[cur_s] + cur_cost;
                System.out.println("-1");
                return;
            }
        }
        for(int i=2; i<=N; i++) {
            if(dis[i] == Integer.MAX_VALUE)
                System.out.println("-1");
            else
                System.out.println(dis[i]);
        }

    }
}