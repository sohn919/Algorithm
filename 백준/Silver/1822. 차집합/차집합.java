import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeSet<Integer> Tset = new TreeSet<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            Tset.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(Tset.contains(n))
                Tset.remove(n);
        }
        System.out.println(Tset.size());
        StringBuilder sb = new StringBuilder();
        for(int i : Tset) {
            sb.append(i + " ");
        }
        System.out.print(sb);
    }
}
