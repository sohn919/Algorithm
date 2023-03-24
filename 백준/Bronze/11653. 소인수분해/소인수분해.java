import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 2;
        while(N > 1) {
            if(N % cnt == 0) {
                sb.append(cnt).append("\n");
                N /= cnt;
            }
            else
                cnt++;
        }
        System.out.print(sb);

    }
}