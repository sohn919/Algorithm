import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Deque<Integer> DqA = new LinkedList<>(Arrays.stream(A)
                .boxed()
                .collect(Collectors.toList()));
        Deque<Integer> DqB = new LinkedList<>(Arrays.stream(B)
                .boxed()
                .collect(Collectors.toList()));
        while (!DqA.isEmpty()) {
            if (DqA.peek() < DqB.peek()) {
                answer += DqA.poll() * DqB.pollLast();
            } else {
                answer += DqA.pollLast() * DqB.poll();
            }
        }
        return answer;
    }
}