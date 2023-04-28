import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(linkedHashSet.contains(s)) {
                linkedHashSet.remove(s);
            }
            linkedHashSet.add(s);
        }
        int cnt = 0;
        for(String s : linkedHashSet) {
            System.out.println(s);
            cnt++;
            if(cnt == N)
                break;
        }
    }
}