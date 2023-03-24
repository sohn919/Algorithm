import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.valueOf(s[1]);
        int answer = 0;
        char[] ch = s[0].toCharArray();
        for(int i=ch.length-1; i>=0; i--) {
            if(Character.isDigit(ch[i])) {
                answer += (ch[i]-'0') * Math.pow(N, ch.length-1-i);
            }
            else {
                int temp = ch[i] - 'A' + 10;
                   answer += temp * Math.pow(N, ch.length-1-i);
            }
        }
        System.out.println(answer);

    }
}