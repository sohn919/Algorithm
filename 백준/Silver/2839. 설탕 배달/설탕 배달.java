import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    final static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[5001];
        Arrays.fill(dp, MAX);
        dp[3] = 1;
        dp[5] = 1;
        for(int i=6; i<=5000; i++) {
            if(dp[i-3] == MAX && dp[i-5] == MAX)
                continue;
            dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
        }
        int answer = dp[N] == MAX ? -1 : dp[N];
        System.out.print(answer);
    }
}