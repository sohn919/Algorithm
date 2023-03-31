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
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        while(num-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] degree = new int[N + 1];
            int[] cost = new int[N + 1];
            ArrayList<Integer>[] arr = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr[s].add(e);
                degree[e]++;
            }
            int goal = Integer.parseInt(br.readLine());
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
            sb.append(answer[goal]).append("\n");

        }
        System.out.print(sb);
    }
}