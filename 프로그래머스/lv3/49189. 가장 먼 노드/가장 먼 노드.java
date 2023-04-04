import java.util.*;
class Solution {
    ArrayList<Integer>[] arr;
    boolean[] visited;
    int[] check;
    public void BFS(int n) {
        visited[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()) {
            int a = q.poll();
            for(int i : arr[a]) {
                if(visited[i])
                    continue;
                check[i] = check[a] + 1;
                visited[i] = true;
                q.add(i);
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++) {
            arr[edge[i][0]].add(edge[i][1]);
            arr[edge[i][1]].add(edge[i][0]);
        }
        visited = new boolean[n+1];
        check = new int[n+1];
        BFS(1);
        int cnt = Arrays.stream(check).max().getAsInt();
        for(int i=1; i<=n; i++) {
            if(cnt == check[i])
                answer++;
        }
        return answer;
    }
}