import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        int[] degree = new int[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            degree[e]++;
            arr[s].add(e);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        boolean flag = false;
        for(int i=1; i<=N; i++) {
            if(degree[i] == 0)
                q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp + " ");
            for(int a : arr[temp]) {
                degree[a]--;
                if(degree[a] == 0) {
                    q.add(a);
                }
            }
        }
        System.out.print(sb);
    }
}