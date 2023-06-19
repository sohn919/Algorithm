import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = new int[2];
        solution(0, 0, N);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static void solution(int n, int m, int end) {
        for(int i=n; i<n+end; i++) {
            for(int j=m; j<m+end; j++) {
                if(board[n][m] != board[i][j]) {
                    solution(n, m, end/2); // 1 사분면; 0, 0, 4 -> 4, 4
                    solution(n, end/2 + m, end/2); // 2; 0, 4, 4 -> 4, 8
                    solution(end/2 + n, m, end/2); // 3; 4, 0, 4 -> 8, 4
                    solution(end/2 + n, end/2 + m, end/2); // 4; 4, 4, 4 -> 8, 8
                    return;
                }
            }
        }
        answer[board[n][m]]++;
    }
}