import java.util.Arrays;
class Solution {
    public int solution(int[] number) {
        int answer = 0;
        Arrays.sort(number);
        for(int i=0; i<number.length-2; i++) {
            for(int j=i+1; j<number.length-1; j++) {
                for(int k=number.length-1; k>j; k--) {
                    int sum = number[i] + number[j] + number[k];
                    if (sum < 0) break;
                    else if (sum == 0) answer++;
                }
            }
        }
        return answer;
    }
}