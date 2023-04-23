import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, answer = Integer.MAX_VALUE;
    static int[][] board, copyBoard, operation;
    static int[] combi;
    static boolean[] visit; // 조합 방문 처리

    // 조합(k^2)36 -> 회전 연산(n^2)2500 36 * 2500 끝난 후 -> 최솟값 구하기(n^2) 최솟 값 + 26 * 2500 18
    public static void DFS(int L) {
        if(L == K) {
            // 배열 회전
            rotation();
            // 최솟값 구하기
            answer = Math.min(solution(), answer);
        }
        else {
            for(int i=0; i<K; i++) {
                if(visit[i])
                    continue;
                combi[L] = i;
                visit[i] = true;
                DFS(L+1);
                visit[i] = false;
            }
        }

    }
    // k^4  (1, 2) (5, 6)
    public static void rotation() {
        for(int i=1; i<=N; i++) {
            copyBoard[i] = board[i].clone();
        }
        for(int i=0; i<K; i++) {
            int startX = operation[combi[i]][0] - operation[combi[i]][2];
            int startY = operation[combi[i]][1] - operation[combi[i]][2];
            int endX = operation[combi[i]][0] + operation[combi[i]][2];
            int endY = operation[combi[i]][1] + operation[combi[i]][2];
            rotationMethod(startX, startY, endX, endY, copyBoard);
        }
    }

    public static void rotationMethod(int startX, int startY, int endX, int endY, int[][] copyBoard) {
        if(startX == endX && startY == endY)
            return;
        int[] saveArr = new int[3];
        saveArr[0] = copyBoard[startX][endY];
        saveArr[1] = copyBoard[endX][endY];
        saveArr[2] = copyBoard[endX][startY];
        // 오른쪽 회전
        for(int i=endY; i>startY; i--) {
            copyBoard[startX][i] = copyBoard[startX][i-1];
        }
        // 아래로 회전
        for(int i=endX; i>startX; i--) {
            if(i == startX + 1) {
                copyBoard[i][endY] = saveArr[0];
            }
            else
                copyBoard[i][endY] = copyBoard[i-1][endY];
        }
        // 왼쪽으로 회전
        for(int i=startY; i<endY; i++) {
            if(i == endY - 1) {
                copyBoard[endX][i] = saveArr[1];
            }
            else
                copyBoard[endX][i] = copyBoard[endX][i+1];
        }
        // 위쪽으로 회전
        for(int i=startX; i<endX; i++) {
            if(i == endX - 1) {
                copyBoard[i][startY] = saveArr[2];
            }
            else
                copyBoard[i][startY] = copyBoard[i+1][startY];
        }
        rotationMethod(startX+1, startY+1, endX-1, endY-1, copyBoard);
    }

    // n^2
    public static int solution() {
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            int sum = 0;
            for(int j=1; j<=M; j++) {
                sum += copyBoard[i][j];
            }
            min = Math.min(sum, min);
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        copyBoard = new int[N+1][M+1];
        visit = new boolean[K];
        operation = new int[K][3];
        combi = new int[K];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 회전 연산 담기
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                operation[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0);
        System.out.println(answer);
    }
}