import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int[] unf;

    public static int find(int a) {
        if(unf[a] == a)
            return a;
        else
            return unf[a] = find(unf[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            unf[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            int M = Integer.valueOf(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            unf = new int[M+1];
            for(int i=1; i<=M; i++) {
                unf[i] = i;
            }
            for(int i=1; i<=M; i++) {
                int b = Integer.valueOf(st.nextToken());
                union(i, b);
            }
            for(int i=1; i<=M; i++) {
                find(i);
            }
            HashSet<Integer> Hset = new HashSet<>();
            for(int i=1; i<=M; i++) {
                Hset.add(unf[i]);
            }
            sb.append(Hset.size()).append("\n");

        }
        System.out.print(sb);
    }
}