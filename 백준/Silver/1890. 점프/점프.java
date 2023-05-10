import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dp[i][j] == 0)
                    continue;
                if(i == N-1 && j == N-1)
                    break;
                int temp = board[i][j];
                if(i + temp < N) {
                    dp[i+temp][j] += dp[i][j];
                }
                if(j + temp < N) {
                    dp[i][j+temp] += dp[i][j];
                }
            }
        }
        System.out.print(dp[N-1][N-1]);
    }
}