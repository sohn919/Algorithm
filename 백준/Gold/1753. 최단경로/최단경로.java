import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int e, cost;
    Edge(int e, int cost) {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[s].add(new Edge(e, cost));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        dis[start] = 0;
        pQ.add(new Edge(start, 0));
        boolean[] visited = new boolean[N+1];
        while(!pQ.isEmpty()) {
            Edge o = pQ.poll();
            if(visited[o.e])
                continue;
            visited[o.e] = true;
            for(Edge edge : arr[o.e]) {
                if(dis[o.e] != Integer.MAX_VALUE && dis[edge.e] > dis[o.e] + edge.cost) {
                    dis[edge.e] = dis[o.e] + edge.cost;
                    pQ.add(new Edge(edge.e, dis[edge.e]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(dis[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dis[i]).append("\n");
        }
        System.out.print(sb);

    }
}