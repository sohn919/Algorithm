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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[s].add(new Edge(e, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] disx = new int[N+1];
        int[] disy = new int[N+1];
        Arrays.fill(disx, Integer.MAX_VALUE);
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(start, 0));
        disx[start] = 0;
        boolean[] visited = new boolean[N+1];
        while(!pQ.isEmpty()) {
            Edge cur = pQ.poll();
            if(visited[cur.e])
                continue;
            visited[cur.e] = true;
            for(Edge next : arr[cur.e]) {
                if(disx[next.e] > disx[cur.e] + next.cost) {
                    disx[next.e] = disx[cur.e] + next.cost;
                    pQ.add(new Edge(next.e, disx[next.e]));
                    disy[next.e] = cur.e;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int cur = end;
        while(cur != 0) {
            answer.add(cur);
            cur = disy[cur];
        }
        System.out.println(disx[end]);
        System.out.println(answer.size());
        for(int i = answer.size() - 1; i >= 0; i--) {
            System.out.print(answer.get(i) + " ");
        }

    }
}