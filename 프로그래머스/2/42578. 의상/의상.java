import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hashMap = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        int answer = 1;
        if(hashMap.size() == 1) {
            return answer * clothes.length;
        }
        for(String s : hashMap.keySet()) {
            answer *= (hashMap.get(s) + 1);
        }
        return answer - 1;
    }
}