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

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            arr[s].add(new Edge(e, cost));
        }

        int[] answer = new int[N+1];
        boolean[] visit = new boolean[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        PriorityQueue<Edge> q = new PriorityQueue<>();
        answer[start] = 0;
        q.add(new Edge(start, 0));
        while(!q.isEmpty()) {
            Edge edge = q.poll();
            visit[edge.e] = true;
            for(Edge edge1 : arr[edge.e]) {
                if(!visit[edge1.e] && answer[edge1.e] > answer[edge.e] + edge1.cost) {
                    answer[edge1.e] = answer[edge.e] + edge1.cost;
                    q.add(new Edge(edge1.e, answer[edge1.e]));
                }
            }
        }
        for(int i=1; i<=N; i++) {
            if(answer[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else
                System.out.println(answer[i]);
        }
    }
}