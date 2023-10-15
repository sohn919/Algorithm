import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static int[] unf;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        unf = new int[n];
        for (int i=0; i<n; i++) {
            unf[i] = i;
        }
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        for (int i=0; i<costs.length; i++) {
            int findCostA = find(costs[i][0]);
            int findCostB = find(costs[i][1]);
            if (findCostA == findCostB) {
                continue;
            }
            union(costs[i][0], costs[i][1]);
            answer += costs[i][2];
        }
        return answer;
    }

    public int find(int a) {
        if (unf[a] == a) {
            return a;
        }
        return unf[a] = find(unf[a]);
    }

    public void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA > findB) {
            unf[findB] = findA;
        } else {
            unf[findA] = findB;
        }
    }
}