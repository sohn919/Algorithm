import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S, T;
    static int answer = 0;

    public static void DFS(String str) {
        if(str.length() < S.length())
            return;
        if(str.equals(S)) {
            answer = 1;
            return;
        }
        else {
            if(str.charAt(0) == 'B') {
                StringBuilder sb = new StringBuilder(str);
                String s = sb.reverse().toString();
                DFS(s.substring(0, s.length() - 1));
            }
            if(str.charAt(str.length() - 1) == 'A') {
                DFS(str.substring(0, str.length() - 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        DFS(T);
        System.out.println(answer);
    }
}