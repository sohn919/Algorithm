import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arrA = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arrB = new int[M][K];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] answer = new int[N][K];
        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                for(int l=0; l<M; l++) {
                    answer[i][j] += arrA[i][l] * arrB[l][j];
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}