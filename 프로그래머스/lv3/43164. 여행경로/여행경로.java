import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    String[] answer = {};
    boolean flag = false;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        for (int i=0; i<tickets.length; i++) {
            if (!tickets[i][0].equals("ICN")) continue;
            boolean[] visited = new boolean[tickets.length];
            List<String> solution = new ArrayList<>();
            solution.add(tickets[i][0]);
            solution.add(tickets[i][1]);
            visited[i] = true;
            DFS(tickets, visited, tickets[i][1], solution);
            visited[i] = false;

            if (answer.length == tickets.length + 1) {
                return answer;
            }
        }
        return null;
    }

    public void DFS(String[][] tickets, boolean[] visited, String start, List<String> solution) {
        if (solution.size() == tickets.length + 1) {
            flag = true;
            answer = solution.toArray(new String[tickets.length + 1]);
            return;
        }
        if (flag) return;
        for (int i=0; i<tickets.length; i++) {
            if (visited[i]) continue;
            if (tickets[i][0].equals(start)) {
                visited[i] = true;
                solution.add(tickets[i][1]);
                DFS(tickets, visited, tickets[i][1], solution);
                int i1 = solution.lastIndexOf(tickets[i][1]);
                solution.remove(i1);
                visited[i] = false;
            }
        }
    }
}