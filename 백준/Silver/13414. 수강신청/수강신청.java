import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new LinkedHashSet<>();
        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(set.contains(s)) set.remove(s);
            set.add(s);
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(String s : set) {
            sb.append(s).append("\n");
            cnt++;
            if(cnt == N) break;
        }
        System.out.print(sb);
    }
}