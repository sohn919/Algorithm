import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
            for(int i=1; i<unf.length; i++) {
                if(unf[i] == b)
                    unf[i] = a;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        unf = new int[N+1];
        for(int i=0; i<=N; i++) {
            unf[i] = i;
        }
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int temp = Integer.valueOf(st.nextToken());
                if(temp == 1)
                    union(i, j);
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i=0; i<M; i++) {
            int temp = Integer.valueOf(st.nextToken());
            if(i == 0) {
                answer = unf[temp];
            }
            else {
                if(answer != unf[temp] && answer != 0) {
                    System.out.print("NO");
                    return;
                }
            }
        }
//        for(int i : unf) {
//            System.out.print(i + " ");
//        }
        System.out.print("YES");
    }
}