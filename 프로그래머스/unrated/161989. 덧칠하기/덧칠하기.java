class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] paint = new int[n+1];
        for(int i=0; i<section.length; i++) {
            paint[section[i]] = 1;
        }
        for(int i=1; i<=n; i++) {
            if(paint[i] == 1) {
                for(int j=i; j<i+m; j++) {
                    if(j > n)
                        break;
                    paint[j] = 0;
                }
                answer++;
            }
        }
        return answer;
    }
}