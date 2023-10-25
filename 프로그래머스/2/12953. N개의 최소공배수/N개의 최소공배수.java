import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        long temp = arr[arr.length-1];
        for (int i=arr.length-2; i>=0; i--) {
            temp = lcm(temp, arr[i]);
        }
        int answer = (int) temp;
        return answer;
    }
    public long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}