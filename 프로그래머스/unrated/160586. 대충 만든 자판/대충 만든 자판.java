import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] sol = new int[26];
        Arrays.fill(sol, Integer.MAX_VALUE);
        for(int i=0; i<keymap.length; i++) {
            for(int j=0; j<keymap[i].length(); j++) {
                int temp = keymap[i].charAt(j) - 'A';
                sol[temp] = Math.min(j+1, sol[temp]);
            }
        }
        for(int i=0; i<targets.length; i++) {
            int cnt = 0;
            for(char ch : targets[i].toCharArray()) {
                if(sol[ch - 'A'] == Integer.MAX_VALUE) {
                    cnt = Integer.MAX_VALUE;
                    break;
                } 
                cnt += sol[ch - 'A'];
            }
            answer[i] = cnt == Integer.MAX_VALUE ? -1 : cnt;
        }
        return answer;
    }
}