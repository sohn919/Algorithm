import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        if(a != b) {
            unf[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            union(a, b);
        }
        int temp = find(1);
        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if(temp == find(i))
                answer++;
        }
        System.out.print(answer);
    }
}