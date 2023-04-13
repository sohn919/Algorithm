import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(String[] park, String[] routes) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayList<String> dir = new ArrayList<>(Arrays.asList("N", "E", "S", "W"));
        int[][] map = new int[park.length][park[0].length()];
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if(park[i].charAt(j) == 'S')
                    q.add(new Point(i, j));
                if(park[i].charAt(j) == 'X')
                    map[i][j] = 1;
            }
        }

        for(int i=0; i<routes.length; i++) {
            Point o = q.poll();
            System.out.println(o.x + " " + o.y);
            String[] str = routes[i].split(" ");
            int len = Integer.parseInt(str[1]);
            int nx = o.x;
            int ny = o.y;
            for(int j=0; j<len; j++) {
                nx = nx + dx[dir.indexOf(str[0])];
                ny = ny + dy[dir.indexOf(str[0])];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    q.add(o);
                    break;
                }
                if(map[nx][ny] == 1) {
                    q.add(o);
                    break;
                }
            }
            if(q.isEmpty()) {
                q.add(new Point(nx, ny));
            }
        }

        Point o = q.poll();
        int[] answer = {o.x, o.y};
        return answer;
    }
}