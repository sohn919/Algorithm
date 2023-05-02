import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if(N != 0) {
            st = new StringTokenizer(br.readLine());
        }
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        if(N == P && score <= arr[arr.length - 1]) {
            System.out.print(-1);
            return;
        }
        int cnt = 1;
        for(int i=0; i<N; i++) {
            if(score < arr[i]) {
                cnt++;
            }
            else
                break;
        }
        System.out.print(cnt);
    }
}