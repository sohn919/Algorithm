import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(arr, N);
    }

    public static void solution(int[] arr, int N) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            q.add(i);
        }
        for(int num : arr) {
            int lt = 0;
            while(true) {
                int temp = q.poll();
                if(temp != num) {
                    q.add(temp);
                    lt++;
                }
                else {
                    answer += Math.min(lt, q.size() + 1 - lt);
                    break;
                }
            }
        }
        System.out.print(answer);
    }
}