class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] firstPlusSeq = new int[sequence.length];
        int[] firstMinSeq = new int[sequence.length];
        for (int i=0; i<sequence.length; i++) {
            if (i % 2 == 0) {
                firstPlusSeq[i] = sequence[i];
                firstMinSeq[i] = sequence[i] * -1;
            } else {
                firstPlusSeq[i] = sequence[i] * -1;
                firstMinSeq[i] = sequence[i];
            }
        }
        long[] plusDp = new long[sequence.length];
        long[] minDp = new long[sequence.length];
        plusDp[0] = firstPlusSeq[0];
        minDp[0] = firstMinSeq[0];
        answer = Math.max(plusDp[0], minDp[0]);
        for (int i=1; i<sequence.length; i++) {
            plusDp[i] = Math.max(firstPlusSeq[i], plusDp[i-1] + firstPlusSeq[i]);
            minDp[i] = Math.max(firstMinSeq[i], minDp[i-1] + firstMinSeq[i]);
            answer = Math.max(answer, Math.max(plusDp[i], minDp[i]));
        }
        return answer;
    }
}