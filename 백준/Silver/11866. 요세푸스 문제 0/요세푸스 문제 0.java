import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = 1;
        while(q.size() > 1) {
            if(cnt % K == 0) {
                sb.append(q.poll() + ", ");
                cnt = 1;
                continue;
            }
            q.offer(q.poll());
            cnt++;
        }
        sb.append(q.poll() + ">");
        System.out.print(sb);
    }
}