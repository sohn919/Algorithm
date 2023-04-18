import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer = 0;
    static int[][] board;

    // 3가지 선택지로 가야함 조건 있음
    public static void DFS(int x, int y, int pipe) {
        if(x == N && y == N) {
            answer++;
        }
        else {
            // pipe 가 가로일 때
            if(pipe == 1) {
                if(search(x, y+1, 1)) {
                    DFS(x, y+1, 1);
                }
                if(search(x+1, y+1, 3)) {
                    DFS(x+1, y+1, 3);
                }
            }
            // pipe 가 세로일 때
            if(pipe == 2) {
                if(search(x+1, y, 2)) {
                    DFS(x+1, y, 2);
                }
                if(search(x+1, y+1, 3)) {
                    DFS(x+1, y+1, 3);
                }
            }
            // pipe 가 대각선 일 때
            if(pipe == 3) {
                if(search(x, y+1, 1)) {
                    DFS(x, y+1, 1);
                }
                if(search(x+1, y, 2)) {
                    DFS(x+1, y, 2);
                }
                if(search(x+1, y+1, 3)) {
                    DFS(x+1, y+1, 3);
                }
            }
        }
    }

    // 가로 = 1, 세로 = 2, 대각 = 3(대각은 검증 필요)
    public static boolean search(int x, int y, int pipe) {
        if(x <= 0 || x > N || y <= 0 || y > N) {
            return false;
        }
        if(pipe == 1 && board[x][y] == 1) {
            return false;
        }
        if(pipe == 2 && board[x][y] == 1) {
            return false;
        }
        if(pipe == 3 && board[x][y] == 1) {
            return false;
        }
        if(pipe == 3) {
            if(board[x-1][y] == 1 || board[x][y-1] == 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // (1, 2) 에서 무조건 시작하며 3개의 경우의 수로 벌려짐 DFS 생각
        DFS(1, 2, 1);
        System.out.print(answer);
    }
}