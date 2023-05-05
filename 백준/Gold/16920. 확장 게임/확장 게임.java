import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M, player;
    static int[] playerCnt, answer;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Point>[] castle;

    public static int move(Queue<Point> q, int playerNum, int num) {
        int cnt = 0;
        int dis = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Point o = q.poll();
                for(int j=0; j<4; j++) {
                    int nx = o.x + dx[j];
                    int ny = o.y + dy[j];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                        continue;
                    if(board[nx][ny] == 0) {
                        q.add(new Point(nx, ny));
                        board[nx][ny] = num;
                        cnt++;
                    }
                }
            }
            dis++;
            if(dis > playerNum)
                break;
        }
        return cnt;
    }

    public static void solution() {
        castle = new Queue[player + 1];
        answer = new int[player + 1];
        for(int i=0; i<=player; i++) {
            castle[i] = new LinkedList<>();
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] > 0 && board[i][j] != Integer.MAX_VALUE) {
                    castle[board[i][j]].add(new Point(i, j));
                    answer[board[i][j]]++;
                }
            }
        }
        int num = 1;
        int round = 0;
        while(true) {
            int playerNum = playerCnt[num];
            int cnt = move(castle[num], playerNum, num);
            answer[num] += cnt;
            round += cnt;
            num++;
            if(num == player + 1) {
                if(round == 0)
                    break;
                round = 0;
                num = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        player = Integer.parseInt(st.nextToken());
        playerCnt = new int[player + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=player; i++) {
            playerCnt[i] = Integer.parseInt(st.nextToken());
        }
        board = new int[N][M];

        // board 초기화
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                if(s.charAt(j) == '.') {
                    board[i][j] = 0;
                }
                else if(s.charAt(j) == '#') {
                    board[i][j] = Integer.MAX_VALUE;
                }
                else {
                    board[i][j] = s.charAt(j) - '0';
                }
            }
        }
        solution();
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=player; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.print(sb);
    }
}