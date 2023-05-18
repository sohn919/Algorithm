import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num+1];
        int[] value = new int[num+1];
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[num+1];
        for(int i=0; i<=num; i++) {
            for(int j=0; j<i; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            if(arr[i] + i > num)
                continue;
            dp[arr[i] + i] = Math.max(dp[arr[i] + i], dp[i] + value[i]);
        }
        System.out.print(dp[num]);
    }
}