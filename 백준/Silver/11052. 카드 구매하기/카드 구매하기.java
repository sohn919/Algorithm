import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		long[] dp = new long[1001];
		dp[1] = arr[1];
		for(int i=2; i<=N; i++) {
			for(int j=i; j>=1; j--) {
				dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
			}
		}
		System.out.print(dp[N]);
	}
}