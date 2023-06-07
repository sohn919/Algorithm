import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 666;
        int cnt = 1;
        while(cnt != N) {
            answer++;
            if(Integer.toString(answer).contains("666")) cnt++;
        }
        System.out.print(answer);
    }
}