import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int lt=0, rt=1;
        int[] memo = new int[100001];
        memo[arr[lt]] = 1;
        int answer = 1;
        while(rt < N) {
            if(memo[arr[rt]] + 1 > K) {
                memo[arr[lt]]--;
                lt++;
            } else {
                answer = Math.max(rt - lt + 1, answer);
                memo[arr[rt]]++;
                rt++;
            }
        }
        System.out.print(answer);
    }
}
