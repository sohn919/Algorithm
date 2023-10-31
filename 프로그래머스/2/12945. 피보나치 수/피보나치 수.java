import java.util.Arrays;

class Solution { 
    static int[] arr;
    public int solution(int n) {
        int answer = 0;
        arr = new int[n+1];
        Arrays.fill(arr, -1);
        answer = fibo(n);
        return answer;
    }
    
    public int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (arr[n] != -1) return arr[n];
        return arr[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
    }
}