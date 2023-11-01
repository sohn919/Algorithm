import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stackContainer = new Stack<>();
        int idx = 0;
        int con = 1;
        while (idx < order.length) {
            int orderCnt = order[idx];
            // System.out.println(con + " " + orderCnt);
            if (con < orderCnt) {
                stackContainer.push(con);
                con++;
                continue;
            }
            if (con == orderCnt) {
                answer++;
                con++;
                idx++;
                continue;
            }
            if (!stackContainer.isEmpty() && stackContainer.peek() == orderCnt) {
                answer++;
                stackContainer.pop();
                idx++;
                continue;
            }
            break;
        }
        return answer;
    }
}