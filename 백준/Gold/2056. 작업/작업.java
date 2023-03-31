import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] degree = new int[N+1];
        int[] cost = new int[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int co = Integer.parseInt(st.nextToken());
            cost[i] = co;
            int M = Integer.parseInt(st.nextToken());
            for(int j=0; j<M; j++) {
                int e = Integer.parseInt(st.nextToken());
                degree[e]++;
                arr[i].add(e);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[N+1];
        for(int i=1; i<=N; i++) {
            if(degree[i] == 0) {
                q.add(i);
                answer[i] = cost[i];
            }
        }
        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int next : arr[temp]) {
                degree[next]--;
                if(degree[next] == 0) {
                    q.add(next);
                }
                answer[next] = Math.max(answer[next], answer[temp] + cost[next]);
            }
        }
        int prt = 0;
        for(int a : answer)
            prt = Math.max(prt, a);
        System.out.print(prt);
    }
}