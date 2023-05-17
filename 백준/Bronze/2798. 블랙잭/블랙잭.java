import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visited;

    public static void DFS(int L, int sum) {
        if(sum > M)
            return;
        if(L == 3) {
            if(sum <= M)
                answer = Math.max(answer, sum);
        } else {
            for(int i=0; i<N; i++) {
                if(visited[i])
                    continue;
                visited[i] = true;
                DFS(L+1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        visited = new boolean[N];
        DFS(0, 0);
        System.out.println(answer);
    }
}