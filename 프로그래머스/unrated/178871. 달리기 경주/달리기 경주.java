import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> Hmap = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            answer[i] = players[i];
            Hmap.put(players[i], i);
        }
        for(String str : callings) {
            int num = Hmap.get(str);
            String temp = answer[num];
            answer[num] = answer[num - 1];
            answer[num - 1] = temp;
            Hmap.put(answer[num], num);
            Hmap.put(answer[num - 1], num - 1);
        }
        return answer;
    }
}