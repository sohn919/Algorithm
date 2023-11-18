class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        // 1 2 3 4 5 6 7 8
        // 1 2 3 4
        // 1 2
        while (true) {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
            if (a == b) 
                return answer;
            answer++;
        }
    }
}