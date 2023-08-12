import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> pQ = new PriorityQueue<>();
        Queue<Integer> rpQ = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            if (operation.equals("D -1")) {
                if (!pQ.isEmpty()) {
                    Integer poll = pQ.poll();
                    rpQ.remove(poll);
                }
                continue;
            }
            if (operation.equals("D 1")) {
                if (!pQ.isEmpty()) {
                    Integer poll = rpQ.poll();
                    pQ.remove(poll);
                }
                continue;
            }
            String[] str = operation.split(" ");
            pQ.offer(Integer.parseInt(str[1]));
            rpQ.offer(Integer.parseInt(str[1]));
        }
        if (!pQ.isEmpty()) {
            answer[0] = rpQ.poll();
            answer[1] = pQ.poll();
        }
        return answer;
    }
}