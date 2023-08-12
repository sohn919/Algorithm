class Solution {
    public int solution(int n, int[][] computers) {
     int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            DFS(visited, computers, i);
            answer++;
        }
        return answer;
    }

    public static void DFS(boolean[] visited, int[][] computers, int num) {
        for (int j=0; j<computers[num].length; j++) {
            if (computers[num][j] == 1 && !visited[j]) {
                visited[j] = true;
                DFS(visited, computers, j);
            }
        }
    }
}