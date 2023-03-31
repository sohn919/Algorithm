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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] cntarr = new int[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            arr[s].add(e);
            cntarr[e]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(cntarr[i] == 0)
                q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp + " ");
            for(int a : arr[temp]) {
                cntarr[a]--;
                if(cntarr[a] == 0)
                    q.add(a);
            }
        }
        System.out.println(sb);
    }
}