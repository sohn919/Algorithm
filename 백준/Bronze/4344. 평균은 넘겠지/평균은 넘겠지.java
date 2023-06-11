import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            int sum = 0;
            for(int j=0; j<num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            double avg = Arrays.stream(arr).average().getAsDouble();
            long filter = Arrays.stream(arr).filter(x -> x > avg).count();
            System.out.printf("%.3f%%\n", (double)filter / num * 100);
        }
    }
}