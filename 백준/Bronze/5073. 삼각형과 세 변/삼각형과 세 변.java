import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0 & C == 0) break;
            int max = Math.max(A, Math.max(B, C));
            if(max >= A + B + C - max) sb.append("Invalid").append("\n");
            else if(A == B && B == C) sb.append("Equilateral").append("\n");
            else if(A != B && B != C && A != C) sb.append("Scalene").append("\n");
            else sb.append("Isosceles").append("\n");
        }
        System.out.print(sb);
    }
}
