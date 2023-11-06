import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] arr = new int[n+1][n+1];
        for (int i=0; i<wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        boolean[][] visited = new boolean[n+1][n+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (arr[i][j] == 0) continue;
                if (visited[i][j]) continue;
                visited[i][j] = true;
                visited[j][i] = true;
                arr[i][j] = 0;
                arr[j][i] = 0;
                int result = BFS(n, arr);
                arr[i][j] = 1;
                arr[j][i] = 1;
                // System.out.println(result);
                answer = Math.min(answer, Math.abs((n - result) - result));
            }
        }
        return answer;
    }
    
    public int BFS(int len, int[][] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visited = new boolean[len+1];
        visited[1] = true;
        int sum = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i=0; i<arr[cur].length; i++) {
                if (visited[i]) continue;
                if (arr[cur][i] == 0) continue;
                q.add(i);
                visited[i] = true;
                sum++;
            }
        }
        return len - sum;
    }
}