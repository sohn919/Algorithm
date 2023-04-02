import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int e, cost;
    public Edge(int e, int cost) {
        this.e = e;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] arr = new ArrayList[N+1];
        int[] dis = new int[N+1];
        int[] degree = new int[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            degree[e]++;
            arr[s].add(new Edge(e, cost));
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=1; i<=N; i++) {
            if(degree[i] == 0) {
                q.add(i);
                dis[i] = 1;
            }
        }
        boolean[] check = new boolean[N+1];
        while(!q.isEmpty()) {
            int a = q.poll();
            if(arr[a].size() == 0) {
                check[a] = true;
                continue;
            }
            for(Edge edge : arr[a]) {
                degree[edge.e]--;
                if(degree[edge.e] == 0) {
                    q.add(edge.e);
                }
                dis[edge.e] += (dis[a] * edge.cost);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(check[i])
                sb.append(i + " " + dis[i]).append("\n");
        }
        System.out.print(sb);
    }
}