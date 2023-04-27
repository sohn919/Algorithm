import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }
        int lt = 0, rt = 0;
        int answer = Integer.MAX_VALUE;
        while(rt < arr.length) {
            if(arr[rt] - arr[lt] >= S) {
                answer = Math.min(rt - lt , answer);
                lt++;
            }
            else {
                rt++;
            }
        }
        if(answer == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(answer);
    }
}