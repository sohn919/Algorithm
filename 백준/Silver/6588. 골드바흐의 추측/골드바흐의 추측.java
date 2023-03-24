import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int[] arr = new int[1000001];
        for(int i=2; i<=Math.sqrt(1000000); i++) {
            for(int j=i*i; j<=1000000; j+=i) {
                arr[j] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!(s = br.readLine()).equals("0")) {
            int n = Integer.valueOf(s);
            int answer = 0;
            for(int i=3; i<=n/2; i++) {
                if(i%2==1 && (n-i)%2==1 && arr[i] != 1 && arr[n-i] != 1) {
                    answer = i;
                    break;
                }
            }
            if(answer != 0)
                sb.append(n + " = " + answer + " + " + (n-answer) +"\n");
            else
                sb.append("Goldbach's conjecture is wrong.").append("\n");
        }
        System.out.print(sb);
    }
}