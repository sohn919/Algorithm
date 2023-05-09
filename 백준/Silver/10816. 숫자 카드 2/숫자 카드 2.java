import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> Hmap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int a = Integer.parseInt(st.nextToken());
            Hmap.put(a, Hmap.getOrDefault(a, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(Hmap.containsKey(temp))
                sb.append(Hmap.get(temp) + " ");
            else
                sb.append("0 ");
        }
        System.out.print(sb);
    }
}