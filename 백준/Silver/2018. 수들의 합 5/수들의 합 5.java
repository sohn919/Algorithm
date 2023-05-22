import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int lt = 0, rt = 1, sum = lt + rt;
        int answer = 0;
        while(rt < N) {
            if(sum == N) {
                answer++;
                rt++;
                sum += rt;
            } else if(sum < N) {
                rt++;
                sum += rt;
            } else {
                sum -= lt;
                lt++;
            }
        }
        System.out.print(answer+1);
    }
}