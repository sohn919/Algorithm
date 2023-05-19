import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long[] dp = new long[N+1];
        dp[0] = arr[0];
        for(int i=1; i<N; i++) {
            if(i == 1) {
                dp[i] = arr[i-1] + arr[i];
            } else if(i == 2) {
                dp[i] = Math.max(dp[i], Math.max(arr[i-2], arr[i-1]) + arr[i]);
            } else {
                dp[i] = Math.max(dp[i], Math.max(arr[i-1] + dp[i-3], dp[i-2]) + arr[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(Arrays.stream(dp).max().getAsLong());
    }
}