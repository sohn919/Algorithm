import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<7; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp % 2 == 1) {
                min = Math.min(min, temp);
                sum += temp;
            }
        }
        if(sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}