import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Stack<String> card1 = new Stack<>();
        Stack<String> card2 = new Stack<>();
        for(int i=cards1.length-1; i>=0; i--) {
            card1.add(cards1[i]);
        }
        for(int i=cards2.length-1; i>=0; i--) {
            card2.add(cards2[i]);
        }

        for(int i=0; i<goal.length; i++) {
            if(!card1.isEmpty() && card1.peek().equals(goal[i])) {
                card1.pop();
            }
            else if(!card2.isEmpty() && card2.peek().equals(goal[i])) {
                card2.pop();
            }
            else {
                return  "No";
            }
        }
        return answer;
    }
}