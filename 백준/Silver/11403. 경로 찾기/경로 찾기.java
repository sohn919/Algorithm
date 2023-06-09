import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] arr;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N];
        answer = new int[N][N];
        for(int i=0; i<N; i++) arr[i] = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) arr[i].add(j);
            }
        }
        for(int i=0; i<N; i++) {
            DFS(i, i);
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void DFS(int num, int value) {
        for(int nx : arr[value]) {
            if(answer[num][nx] != 1) {
                answer[num][nx] = 1;
                DFS(num, nx);
            }
        }
    }
}