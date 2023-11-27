import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        int len = 0;
        for (int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        for (int i=0; i<=discount.length-10; i++) {
            Map<String, Integer> disMap = new HashMap<>();
            boolean flag = false;
            for (int j=i; j<i+10; j++) {
                disMap.put(discount[j], disMap.getOrDefault(discount[j], 0) + 1);
            }
            for (String str : wantMap.keySet()) {
                int num1 = wantMap.get(str);
                int num2 = disMap.getOrDefault(str, 0);
                if (num1 > num2) flag = true;
            }
            if (!flag) answer++;
        }
        return answer;
    }
}