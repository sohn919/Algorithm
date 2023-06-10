import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp = N;
        int answer = 0;
        while(true) {
            answer++;
            int first = temp / 10;
            int last = temp % 10;
            temp = (last * 10) + ((first + last) % 10);
            if(N == temp) break;
        }
        System.out.print(answer);
    }
}