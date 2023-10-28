import java.util.Arrays;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] arr = new int[27];
        Arrays.fill(arr, -1);
        for (int i=0; i<skill.length(); i++) {
            char ch = skill.charAt(i);
            if (i == 0) {
                arr[ch-'A'+1] = i;
            } else {
                arr[ch-'A'+1] = skill.charAt(i-1)-'A'+1;
            }
        }
        for (int i=0; i<skill_trees.length; i++) {
            boolean[] visited = new boolean[27];
            boolean flag = true;
            for (int j=0; j<skill_trees[i].length(); j++) {
                char ch = skill_trees[i].charAt(j);
                if (arr[ch-'A'+1] == 0) {
                    visited[ch-'A'+1] = true;
                    continue;
                }
                if (arr[ch-'A'+1] > 0 && !visited[arr[ch-'A'+1]]) {
                    flag = false;
                    break;
                }
                if (arr[ch-'A'+1] > 0 && visited[arr[ch-'A'+1]]) {
                    visited[ch-'A'+1] = true;
                    continue;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}