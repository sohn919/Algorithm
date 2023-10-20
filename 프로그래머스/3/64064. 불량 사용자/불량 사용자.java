import java.util.*;

class Solution {
    static int answer = 0;
    static int ban;
    static Set<List<String>> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        ban = user_id.length;
        boolean[] visited = new boolean[ban];
        DFS(user_id, banned_id, visited, 0);
        answer = set.size();
        return answer;
    }

    public void DFS(String[] user_id, String[] banned_id, boolean[] visited, int L) {
        if (L == banned_id.length) {
            List<String> list = new ArrayList<>();
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) {
                    list.add(user_id[i]);
                }
            }
            set.add(list);
            return;
        }
        for (int i=0; i<user_id.length; i++) {
            if (!visited[i] && equalsBanUser(user_id[i], banned_id[L])) {
                visited[i] = true;
                DFS(user_id, banned_id, visited, L+1);
                visited[i] = false;
            }
        }
    }

    public boolean equalsBanUser(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }
        for (int j=0; j<banned.length(); j++) {
            if (user.charAt(j) != banned.charAt(j) && banned.charAt(j) != '*') {
                break;
            }
            if ((banned.charAt(j) == '*' || user.charAt(j) == banned.charAt(j))
                    && j == banned.length() - 1)
            {
                return true;
            }
        }
        return false;
    }
}