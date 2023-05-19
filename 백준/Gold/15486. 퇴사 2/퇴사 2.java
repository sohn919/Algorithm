import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] value = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        for(int i=0; i<N; i++) {
            if(arr[i] + i <= N) {
                dp[arr[i] + i] = Math.max(dp[i] + value[i], dp[arr[i] + i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.print(dp[N]);
    }
}