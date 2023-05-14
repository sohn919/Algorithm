import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R, cnt=1;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] answer;

    public static void DFS(int n) {
        answer[n] = cnt++;
        visited[n] = true;
        for(int num : list[n]) {
            if(visited[num]) {
                continue;
            }
            DFS(num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list[S].add(E);
            list[E].add(S);
        }
        for(int i=0; i<=N; i++)
            Collections.sort(list[i]);
        visited = new boolean[N+1];
        answer = new int[N+1];
        DFS(R);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.print(sb);
    }
}