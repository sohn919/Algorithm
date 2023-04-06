import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=1; i<=N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }
        Arrays.sort(arr);
        int lt = 0;
        int rt = 1;
        int answer = 0;
        while(rt <= N) {
            int temp = arr[rt] - arr[lt];
            if(temp > M) {
                lt++;
                continue;
            }
            if(temp == M) {
                answer++;
            }
            rt++;
        }
        System.out.println(answer);
    }
}
