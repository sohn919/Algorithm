import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue pQ = new PriorityQueue(Collections.reverseOrder());
        while(N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && !pQ.isEmpty()) sb.append(pQ.poll()).append("\n");
            else if(num == 0 && pQ.isEmpty()) sb.append(0).append("\n");
            else pQ.offer(num);
        }
        System.out.print(sb);
    }
}