import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        boolean[] visited = new boolean[y+1];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, 0));
        visited[x] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == y) {
                answer = cur.cost;
                break;
            }
            if (cur.x + n <= y && !visited[cur.x + n]) {
                q.add(new Point(cur.x + n, cur.cost + 1));
                visited[cur.x + n] = true;
            }
            if (cur.x * 2 <= y && !visited[cur.x * 2]) {
                q.add(new Point(cur.x * 2, cur.cost + 1));
                visited[cur.x * 2] = true;
            }
            if (cur.x * 3 <= y && !visited[cur.x * 3]) {
                q.add(new Point(cur.x * 3, cur.cost + 1));
                visited[cur.x * 3] = true;
            }
        }
        return answer;
    }
}
class Point {
    int x, cost;
    
    public Point(int x, int cost) {
        this.x = x;
        this.cost = cost;
    }
}