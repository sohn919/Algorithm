import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n) + " " + (n-2));
    }
    public static int fibonacci(int n) {
        int[] fibo = new int[n+1];
        fibo[1] = 1;
        fibo[2] = 1;
        for(int i=3; i<=n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        return fibo[n];
    }
}
