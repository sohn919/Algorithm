import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> Hmap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(Hmap.get(s.charAt(i)) == null) {
                answer[i] = -1;
                Hmap.put(s.charAt(i), i);
            }
            else {
                answer[i] = i - Hmap.get(s.charAt(i));
                Hmap.put(s.charAt(i), i);
            }
        }
        return answer;
    }
}