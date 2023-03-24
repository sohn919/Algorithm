import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb;
    static int[] checked;
    public static void DFS(int n, int L) {
        if(L == N) {
            return;
        }
        checked[n] = 1;
        sb.append(n + " ");
        for(int i=1; i<=N; i++) {
            if(arr[n][i] == 1 && checked[i] != 1) {
                DFS(i, L+1);
            }
        }
    }

    public static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        checked[n] = 1;
        sb.append(n+" ");
        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int i=1; i<=N; i++) {
                if(arr[temp][i] == 1 && checked[i] != 1) {
                    q.add(i);
                    sb.append(i+" ");
                    checked[i] = 1;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int V = Integer.valueOf(st.nextToken());
        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        sb = new StringBuilder();
        checked = new int[N+1];
        DFS(V, 0);
        sb.append("\n");
        checked = new int[N+1];
        BFS(V);
        System.out.println(sb);
    }
}