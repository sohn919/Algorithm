import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<ch.length; i++) {
            if(Character.isUpperCase(ch[i]))
                answer.append(Character.toLowerCase(ch[i]));
            else
                answer.append(Character.toUpperCase(ch[i]));
        }
        System.out.print(answer);
    }
}