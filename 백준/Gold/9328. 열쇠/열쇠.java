import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y;
    char key;
    public Point(int x, int y, char key) {
        this.x = x;
        this.y = y;
        this.key = key;
    }
}

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, cnt;
    static char[][] board;
    static boolean[][] visited;
    static HashSet<Character> keys;
    static ArrayList<Point> checkedKeys;
    static Queue<Point> q;

    public static boolean checkedKey() {
        boolean flag = false;
        for(Point o : checkedKeys) {
            if(keys.contains(Character.toLowerCase(o.key)) && !visited[o.x][o.y]) {
                flag = true;
                visited[o.x][o.y] = true;
                q.add(o);
            }
        }
        return flag;
    }

    public static int solution() {
        while(true) {
            while(!q.isEmpty()) {
                Point cur = q.poll();
                for(int i=0; i<4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                        continue;
                    if(board[nx][ny] == '*' || visited[nx][ny])
                        continue;
                    // 알파벳이라면?
                    if(Character.isAlphabetic(board[nx][ny])) {
                        // 열쇠라면?
                        if(Character.isLowerCase(board[nx][ny])) {
                            keys.add(board[nx][ny]);
                            q.add(new Point(nx, ny, board[nx][ny]));
                            visited[nx][ny] = true;
                        }
                        // 열쇠가 아닌 문이라면?
                        else {
                            // 문의 열쇠가 있다면?
                            if(keys.contains(Character.toLowerCase(board[nx][ny]))) {
                                q.add(new Point(nx, ny, board[nx][ny]));
                                visited[nx][ny] = true;
                            }
                            else {
                                checkedKeys.add(new Point(nx, ny, board[nx][ny]));
                            }
                        }
                        continue;
                    }
                    // 문서라면?
                    if(board[nx][ny] == '$') {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, '0'));
                        cnt++;
                    }
                    // 문서가 아닌 . 이라면
                    else {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, '0'));
                    }
                }
            }
            if(!checkedKey())
                break;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new char[N][M];
            visited = new boolean[N][M];
            q = new LinkedList<>();
            cnt = 0;
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<M; j++) {
                    if(s.charAt(j) == '.' && (i == 0 || i == N-1 || j == 0 || j == M-1)) {
                        q.add(new Point(i, j, '0'));
                        visited[i][j] = true;
                    }
                    if(s.charAt(j) == '$' && (i == 0 || i == N-1 || j == 0 || j == M-1)) {
                        q.add(new Point(i, j, '0'));
                        visited[i][j] = true;
                        cnt++;
                    }
                    board[i][j] = s.charAt(j);
                }
            }
            keys = new HashSet<>();
            checkedKeys = new ArrayList<>();
            String str = br.readLine();
            for(int i=0; i<str.length(); i++) {
                keys.add(str.charAt(i));
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(i == 0 || i == N-1 || j == 0 || j == M-1) {
                        if (Character.isUpperCase(board[i][j]) && keys.contains(Character.toLowerCase(board[i][j]))) {
                            q.add(new Point(i, j, '0'));
                            visited[i][j] = true;
                        }
                        else if(Character.isUpperCase(board[i][j]) && !keys.contains(Character.toLowerCase(board[i][j]))) {
                            checkedKeys.add(new Point(i, j, board[i][j]));
                        }
                        else if(Character.isLowerCase(board[i][j])) {
                            q.add(new Point(i, j, '0'));
                            keys.add(board[i][j]);
                            visited[i][j] = true;
                        }
                    }
                }
            }
            sb.append(solution() + "\n");
        }
        System.out.print(sb);
    }
}