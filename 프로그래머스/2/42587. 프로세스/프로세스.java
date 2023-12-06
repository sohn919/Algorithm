import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            q.offer(new Point(i, priorities[i]));
        }
        Arrays.sort(priorities);
        int[] arr = new int[priorities.length];
        int cnt = 0;
        for (int i=priorities.length-1; i>=0; i--) {
            arr[cnt] = priorities[i];
            cnt++;
        }
        cnt = 0;
        while (!q.isEmpty()) {
            Point temp = q.poll();
            if (temp.pri == arr[cnt] && temp.num == location) {
                return cnt+1;
            }
            if (temp.pri != arr[cnt]) q.offer(temp);
            if (temp.pri == arr[cnt]) cnt++;
        }
        return answer;
    }
}
class Point {
    int num, pri;
    
    public Point(int num, int pri) {
        this.num = num;
        this.pri = pri;
    }
}