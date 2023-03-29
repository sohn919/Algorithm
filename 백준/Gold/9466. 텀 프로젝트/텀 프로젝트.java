import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check, ischecked;
    static int[] arr;
    static int answer = 0;
    public static void DFS(int num) {
        if(ischecked[num]) {
            return;
        }
        if(check[arr[num]]) {
            ischecked[num] = true;
            answer++;
        }
        check[num] = true;
        DFS(arr[num]);
        ischecked[num] = true;
        check[num] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.valueOf(br.readLine());
        while(N-- > 0) {
            int M = Integer.valueOf(br.readLine());
            answer = 0;
            arr = new int[M+1];
            check = new boolean[M+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=M; i++) {
                arr[i] = Integer.valueOf(st.nextToken());
            }
            ischecked = new boolean[M+1];
            for(int i=1; i<=M; i++) {
                if(ischecked[arr[i]])
                    continue;
                DFS(i);
            }

            sb.append(M - answer).append("\n");
        }
        System.out.print(sb);
    }
}