import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[] answer;
    static PriorityQueue<Integer>[] pQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        pQ = new PriorityQueue[N+1];
        for(int i=0; i<=N; i++)
            pQ[i] = new PriorityQueue<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pQ[start].add(end);
            pQ[end].add(start);
        }
        answer = new int[N+1];
        BFS();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(R);
        boolean[] visited = new boolean[N+1];
        visited[R] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            answer[cur] = cnt++;
            while(!pQ[cur].isEmpty()) {
                int next = pQ[cur].poll();
                if(visited[next])
                    continue;
                q.add(next);
                visited[next] = true;
            }
        }
    }
}
