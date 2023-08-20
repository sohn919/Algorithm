class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }
    public void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        if (begin.equals(target)) {
            answer = Math.min(count, answer);
        }
        for (int i=0; i<words.length; i++) {
            if (visited[i]) {
                continue;
            }
            int isNotEquals = 0;
            for (int j=0; j<words[i].length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    isNotEquals++;
                }
            }
            if (isNotEquals == 1) {
                visited[i] = true;
                dfs(words[i], target, words, visited, count+1);
                visited[i] = false;
            }
        }
    }
}