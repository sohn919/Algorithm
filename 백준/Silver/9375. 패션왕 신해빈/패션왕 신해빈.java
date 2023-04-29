import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> Hmap = new HashMap<>();
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothes = st.nextToken();
                String clothesType = st.nextToken();
                Hmap.put(clothesType, Hmap.getOrDefault(clothesType, 0) + 1);
            }
            int sum = 1;
            for(String s : Hmap.keySet()) {
                sum *= (Hmap.get(s) + 1);
            }
            sb.append(sum-1 + "\n");
        }
        System.out.print(sb);
    }
}