import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            pQ.offer(scoville[i]);
        }
        boolean flag = false;
        while (pQ.size() > 1) {
            int sco = pQ.poll();
            if (sco < K) {
                int second = pQ.poll();
                pQ.offer(sco + (second * 2));
                answer++;
            } else {
                break;
            }
        }
        return pQ.peek() >= K ? answer : -1;
    }
}