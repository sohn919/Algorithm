import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == maps.length-1 && cur.y == maps[0].length-1) {
                answer = cur.cost;
                break;
            }
            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (maps[nx][ny] == 0) {
                    continue;
                }
                q.offer(new Point(nx, ny, cur.cost + 1));
                visited[nx][ny] = true;
            }
        }
        return answer;
    }
}

class Point {
    int x, y, cost;
    
    public Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}