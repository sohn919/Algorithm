import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] sol = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(one[i%5] == answers[i])
                sol[0]++;
            if(two[i%8] == answers[i])
                sol[1]++;
            if(three[i%10] == answers[i])
                sol[2]++;
        }
        int cnt = Arrays.stream(sol).max().getAsInt();
        for(int i=0; i<3; i++) {
            if(cnt == sol[i]) {
                answer.add(i+1);
            }
        }
        return answer;
    }
}