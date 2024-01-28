class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] num = new int[number + 1];
        for(int i=1; i<=number; i++) {
            int cnt = 0;
            for(int j=1; j<=Math.sqrt(i); j++) {
                if (i % j == 0) cnt += 2;
            }
            if ((int) Math.sqrt(i) * (int) Math.sqrt(i) == i) cnt--;
            num[i] = cnt;
        }
        for (int i=1; i<num.length; i++) {
            if (num[i] > limit) answer += power;
            else answer += num[i];
        }
        return answer;
    }
}