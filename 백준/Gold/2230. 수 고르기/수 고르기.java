import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        int lt = 0;
        int rt = 0;
        int answer = Integer.MAX_VALUE;
        while(rt < N) {
            int temp = arr.get(rt) - arr.get(lt);
            if(temp < M) {
                rt++;
                continue;
            }
            if(temp == M) {
                answer = M;
                break;
            }
            answer = Math.min(temp, answer);
            lt++;
        }
        System.out.print(answer);
    }
}