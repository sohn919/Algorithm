import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int s, e, cost;
    public Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}


public class Main {

    static int[] unf;
    public static int find(int a) {
        if(unf[a] == a) {
            return a;
        }
        else {
            return unf[a] = find(unf[a]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            unf[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        unf = new int[N+1];
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        for(int i=1; i<=N; i++) {
            unf[i] = i;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pQ.add(new Edge(s, e, cost));
        }
        int use = 0;
        int answer = 0;
        while(use < N-1) {
            Edge cur = pQ.poll();
            if(find(cur.s) != find(cur.e)) {
                union(cur.s, cur.e);
                answer += cur.cost;
                use++;
            }
        }
        System.out.println(answer);
    }
}
