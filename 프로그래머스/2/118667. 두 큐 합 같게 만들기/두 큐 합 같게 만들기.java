import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        long firstQueueSum = 0;
        long secondQueueSum = 0;
        Queue<Long> first = new LinkedList<>();
        Queue<Long> second = new LinkedList<>();
        for (int i=0; i<queue1.length; i++) {
            first.add(Long.valueOf(queue1[i]));
            second.add(Long.valueOf(queue2[i]));
            firstQueueSum += queue1[i];
            secondQueueSum += queue2[i];
        }
        int idx = 0;
        long sum = (firstQueueSum + secondQueueSum) / 2;
        boolean flag = false;
        if (firstQueueSum == secondQueueSum) {
            return 0;
        }
        while (idx < queue1.length * 4) {
            idx++;
            if (first.isEmpty()) {
                first.offer(second.poll());
                firstQueueSum += first.peek();
                secondQueueSum -= first.peek();
            } else if (second.isEmpty()) {
                second.offer(first.poll());
                secondQueueSum += second.peek();
                firstQueueSum -= second.peek();
            } else {
                if (firstQueueSum > secondQueueSum) {
                    long fQ = first.poll();
                    second.offer(fQ);
                    secondQueueSum += fQ;
                    firstQueueSum -= fQ;
                } else {
                    long sQ = second.poll();
                    first.offer(sQ);
                    firstQueueSum += sQ;
                    secondQueueSum -= sQ;
                }
            }
            if (firstQueueSum == secondQueueSum) {
                flag = true;
                break;
            }
        }
        
        return flag ? idx : -1;
    }
}