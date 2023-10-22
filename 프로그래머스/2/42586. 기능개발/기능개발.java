import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int num = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) {
                num++;
            }
            queue.offer(num);
        }
        while (!queue.isEmpty()) {
            int n = 1;
            Integer poll = queue.poll();
            while (!queue.isEmpty()) {
                if (poll < queue.peek()) {
                    break;
                }
                queue.poll();
                n++;
            }
            answer.add(n);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}