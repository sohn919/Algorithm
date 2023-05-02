import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int lt = 0, rt = arr.length - 1;
        int answer = 0;
        while(lt < rt) {
            int sum = arr[lt] + arr[rt];
            if(sum > X) {
                rt--;
                continue;
            }
            if(sum < X) {
                lt++;
                continue;
            }
            answer++;
            lt++;
        }
        System.out.print(answer);
    }
}