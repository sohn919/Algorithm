class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = arr[i-1] + i;
        }
        int lt = 0;
        int rt = 0;
        while (rt < n+1) {
            if (arr[rt] - arr[lt] < n) {
                rt++;
            } else if (arr[rt] - arr[lt] > n) {
                lt++;
            } else {
                answer++;
                rt++;
            }
        }
        return answer;
    }
}