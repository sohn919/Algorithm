import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0, rt = people.length - 1;
        while (lt <= rt) {
            if (lt == rt) {
                answer++;
                break;
            }
            if (people[lt] + people[rt] > limit) {
                answer++;
                rt--;
            } else {
                answer++;
                lt++;
                rt--;
            }
        }
        return answer;
    }
}
// 50 50 70 80 