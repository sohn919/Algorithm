import java.util.Arrays;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> o2[0] - o1[0]);
        int cur = routes[0][0];
        for (int i=1; i<routes.length; i++) {
            if (routes[i][0] <= cur && routes[i][1] >= cur) {
                continue;
            }
            cur = routes[i][0];
            answer++;
        }
        return answer;
    }
}