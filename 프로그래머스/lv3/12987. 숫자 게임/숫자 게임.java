import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int pA = 0;
        int pB = 0;
        for (int i=0; i<A.length; i++) {
            if (A[pA] > B[pB]) {
                pB++;
            } else if (A[pA] == B[pB]) {
                pB++;
            } else {
                answer++;
                pA++;
                pB++;
            }
        }
        return answer;
    }
}