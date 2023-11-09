class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int cnt = 5 + ((brown - 6) / 2);
        for (int i=3; i<=cnt-3; i++) {
            int j = cnt - i;
            if ((i * j) - brown == yellow) {
                answer[0] = Math.max(i, j);
                answer[1] = Math.min(i, j);
                break;
            }
        }
        return answer;
    }
}