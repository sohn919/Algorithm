import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        PriorityQueue<Fruit> pQ = new PriorityQueue<>();
        for (int tan : map.keySet()) {
            pQ.add(new Fruit(map.get(tan), tan));
        }
        while (k > 0) {
            Fruit o = pQ.poll();
            if (k - o.cnt <= 0) {
                answer++;
                return answer;
            }
            k -= o.cnt;
            answer++;
        }
        return answer;
    }

}

class Fruit implements Comparable<Fruit> {
    int cnt, tan;
    
    public Fruit(int cnt, int tan) {
        this.cnt = cnt;
        this.tan = tan;
    }
    
    @Override
    public int compareTo(Fruit o) {
        return o.cnt - this.cnt;
    }
}