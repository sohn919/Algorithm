import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int set = Integer.MAX_VALUE;
        int num = Integer.MAX_VALUE;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            set = Math.min(set, Integer.parseInt(st.nextToken()));
            num = Math.min(num, Integer.parseInt(st.nextToken()));
        }
        if(N < 6) System.out.println(Math.min(set, num * N));
        else {
            int sum = 0;
            while(N > 0) {
                if(N >= 6) sum += Math.min(set, num * 6);
                else sum += Math.min(set, num * N);
                N = N - 6;
            }
            System.out.println(sum);
        }
    }
}