import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        int[][] board = new int[maps.length][maps[0].length()];
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[i].length(); j++) {
                char ch = maps[i].charAt(j);
                if (Character.isDigit(ch)) {
                    board[i][j] = ch - '0';
                } else {
                    board[i][j] = -1;
                }
            }
        }
        int size = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == -1 || visited[i][j]) continue;
                int sum = board[i][j];
                size++;
                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(i, j));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Point cur = q.poll();
                    for (int k=0; k<4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                        if (visited[nx][ny] || board[nx][ny] == -1) continue;
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        sum += board[nx][ny];
                    }
                }
                list.add(sum);
            }
        }
        if (list.size() == 0)
            return new int[] {-1};
        answer = new int[size];
        for (int i=0; i<size; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}