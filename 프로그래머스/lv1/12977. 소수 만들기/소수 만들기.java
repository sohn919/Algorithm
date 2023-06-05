import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = Arrays.stream(nums).sum();
        int[] prime = new int[sum+1];
        prime[1] = 1;
        for(int i=2; i<=Math.sqrt(sum); i++) {
            for(int j=i+i; j<=sum; j+=i) {
                if(prime[j] == 1) continue;
                prime[j] = 1;
            }
        }
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if(prime[temp] == 0) answer++;
                }
            }
        }
        return answer;
    }
}