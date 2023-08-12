import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pQ.offer(work);
        }
        while (n-- > 0) {
            int num = pQ.poll();
            if (num == 0) break;
            num--;
            pQ.offer(num);
        }
        for (int num : pQ) {
            answer += Math.pow(num, 2);
        }
        return answer;
    }
}