import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[21];
        dp[0] = 1;
        for(int i=1; i<21; i++) {
            dp[i] = dp[i-1] * i;
        }
        System.out.print(dp[N]);
    }
}