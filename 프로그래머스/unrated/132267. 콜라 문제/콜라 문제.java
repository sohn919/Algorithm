class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int bonus = 0;
        while(n / a > 0) {
            answer += (n / a) * b;
            bonus = (n / a) * b;
            n = n % a;
            n += bonus;
        }
        return answer;
    }
}