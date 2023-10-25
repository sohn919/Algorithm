import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int temp = arr[arr.length-1];
        for (int i=arr.length-2; i>=0; i--) {
            temp = lcm(temp, arr[i]);
        }
        return temp;
    }
    public int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}