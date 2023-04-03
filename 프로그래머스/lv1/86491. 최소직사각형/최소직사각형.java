import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        ArrayList<Integer> max = new ArrayList<>();
        ArrayList<Integer> min = new ArrayList<>();
        for(int i=0; i<sizes.length; i++) {
            max.add(Math.max(sizes[i][0], sizes[i][1]));
            min.add(Math.min(sizes[i][0], sizes[i][1]));
        }
        Collections.sort(max, Collections.reverseOrder());
        Collections.sort(min, Collections.reverseOrder());
        return answer = max.get(0) * min.get(0);
    }
}