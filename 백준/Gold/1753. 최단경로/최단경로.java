import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int e, cost;
    public Edge(int e, int cost) {
        this.e = e;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int start = Integer.valueOf(br.readLine());

        ArrayList<Edge>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            arr[s].add(new Edge(e, cost));
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        dis[start] = 0;
        pQ.add(new Edge(start, 0));
        boolean[] visit = new boolean[N+1];
        while(!pQ.isEmpty()) {
            Edge edge = pQ.poll();
            if(visit[edge.e])
                continue;
            visit[edge.e] = true;
            for(Edge o : arr[edge.e]) {
                if(dis[edge.e] != Integer.MAX_VALUE && dis[o.e] > dis[edge.e] + o.cost) {
                    dis[o.e] = dis[edge.e] + o.cost;
                    pQ.add(new Edge(o.e, dis[o.e]));
                }
            }
        }
        for(int i=1; i<=N; i++) {
            if(dis[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dis[i]);
        }
    }
}