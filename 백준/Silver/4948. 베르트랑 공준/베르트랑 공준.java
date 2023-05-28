import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static int MAX_NUM = 123456 * 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[MAX_NUM+1];
        arr[1] = 1;
        for(int i=2; i<Math.sqrt(MAX_NUM); i++) {
            for(int j=i+i; j<=MAX_NUM; j+=i) {
                if(arr[j] == 1) continue;
                arr[j] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int count = 0;
            for(int i=N+1; i<=N*2; i++) {
                if(arr[i] == 0) count++;
            }
            sb.append(count + "\n");
        }
        System.out.print(sb);
    }
}