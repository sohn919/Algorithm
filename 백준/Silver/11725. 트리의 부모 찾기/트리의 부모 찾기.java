import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] arr;
    static int[] answer;
    static boolean[] check;
    public static void DFS(int num) {
        check[num] = true;
        for(int a : arr[num]) {
            if(!check[a]) {
                answer[a] = num;
                DFS(a);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        arr = new ArrayList[N+1];
        answer = new int[N+1];
        check = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        DFS(1);
        for(int i=2; i<=N; i++) {
            System.out.println(answer[i]);
        }

    }
}