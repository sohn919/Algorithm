import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while(N-- > 0) {
            boolean[] arr = new boolean[26];
            boolean flag = false;
            String str = br.readLine();
            for(int i=0; i<str.length(); i++) {
                if(arr[str.charAt(i) - 'a'] && str.charAt(i) != str.charAt(i-1)) flag = true;
                else arr[str.charAt(i) - 'a'] = true;
            }
            answer += flag ? 0 : 1;
        }
        System.out.print(answer);
    }
}