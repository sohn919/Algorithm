import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int cnt = 0;
        for (int i=0; i<score.length; i++) {
            if (pQ.isEmpty()) {
                answer[cnt] = score[i];
                pQ.offer(score[i]);
                cnt++;
                continue;
            }
            if (pQ.size() == k) {
                int temp = pQ.poll();
                if (temp > score[i]) {
                    answer[cnt] = temp;
                    pQ.offer(temp);
                } else {
                    int tmp = pQ.poll();
                    answer[cnt] = Math.min(tmp, score[i]);
                    pQ.offer(tmp);
                    pQ.offer(score[i]);
                }
                cnt++;
            } else {
                pQ.offer(score[i]);
                int temp = pQ.poll();
                answer[cnt] = temp;
                pQ.offer(temp);
                cnt++;
            }
        }
        return answer;
    }
}