import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        while (cnt++ < elements.length) {
            for (int i=0; i<elements.length; i++) {
                int sum = elements[i];
                int temp = cnt - 1;
                for (int j=i+1; ; j++) {
                    if (temp == 0) break;
                    if (j >= elements.length) {
                        j = -1;
                        continue;
                    }
                    sum += elements[j];
                    temp--;
                }
                set.add(sum);
            }
        }
        return answer = set.size();
    }
}