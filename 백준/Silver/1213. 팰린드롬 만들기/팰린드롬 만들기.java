import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }
        int oneLen = 0; String mid = "";
        for(int i=0; i<26; i++) {
            if (arr[i] % 2 == 1) {
                oneLen++;
                mid += (char) (i + 'A');
            }
        }
        if((str.length() % 2 == 0 && oneLen > 0) || (str.length() % 2 == 1 && oneLen != 1)){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            for(int j=0; j<arr[i]/2; j++) {
                sb.append((char) (i + 'A'));
            }
        }
        String answer = "";
        answer += sb.toString() + mid;
        answer += sb.reverse().toString();
        System.out.print(answer);
    }
}