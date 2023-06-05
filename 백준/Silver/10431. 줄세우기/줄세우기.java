import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) arr[i] = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int i=0; i<20; i++) {
                arr[num].add(Integer.parseInt(st.nextToken()));
            }
            int answer = 0;
            for(int i=0; i<20; i++) {
                int cnt = i;
                int min = arr[num].get(i);
                for(int j=i+1; j<20; j++) {
                    if(min > arr[num].get(j)) {
                        cnt = j;
                        min = arr[num].get(j);
                    }
                }
                arr[num].remove(cnt);
                answer += (cnt - i);
                arr[num].add(i, min);
            }
            sb.append(num + " " + answer).append("\n");
        }
        System.out.print(sb);
    }
}