import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for(int i=0; i<N; i++) {
            str[i] = br.readLine();
        }
        int cnt = 1;
        while(true) {
            HashSet<String> hashSet = new HashSet<>();
            for(int i=0; i<N; i++) {
                String s = str[i].substring(str[i].length() - cnt);
                if(hashSet.contains(s)) {
                    cnt++;
                    break;
                }
                if(i == N-1) {
                    System.out.println(cnt);
                    return;
                }
                hashSet.add(s);
            }
        }
    }
}
