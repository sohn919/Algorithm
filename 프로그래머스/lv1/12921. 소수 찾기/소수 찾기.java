class Solution {
    static int[] arr;
    public int solution(int n) {
        int answer = 0;
        arr = new int[1000001];
        for(int i=2; i<=Math.sqrt(1000000); i++) {
            for(int j=i*i; j<=1000000; j+=i) {
                if(arr[j] == 1)
                    continue;
                arr[j] = 1;
            }
        }
        for(int i=2; i<=n; i++) {
            if(arr[i] == 0)
                answer++;
        }
        return answer;
    }
}