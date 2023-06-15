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
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) truck[i] = Integer.parseInt(st.nextToken());
        for(int i=0; i<w; i++) q.add(0);
        int cur_w = 0;
        int index = 0;
        int answer = 0;
        while(index < n) {
            answer++;
            cur_w -= q.poll();
            if(cur_w + truck[index] <= l) {
                q.add(truck[index]);
                cur_w += truck[index++];
            } else q.add(0);
        }
        System.out.println(answer + q.size());
    }
}