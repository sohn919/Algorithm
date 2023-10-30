import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<26; i++) {
            map.put("" + (char) (i + 'A'), i+1);
        }
        int idx = 27;
        for (int i=0; i<msg.length(); i++) {
            int temp = 0;
            for (int j=i; j<msg.length(); j++) {
                String str = msg.substring(i, j+1);
                if (map.containsKey(str)) {
                    temp = map.get(str);
                    if (j == msg.length() - 1) {
                        i = j;
                    }
                } else {
                    map.put(str, idx);
                    idx++;
                    i = j-1;
                    break;
                }
            }
            answer.add(temp);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
}