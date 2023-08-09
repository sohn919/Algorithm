class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] arr = new int[triangle.length][triangle.length];
        arr[0][0] = triangle[0][0];
        for (int i=1; i<triangle.length; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i-1][j] + triangle[i][j];
                    continue;
                }
                if (j == triangle[i].length - 1) {
                    arr[i][j] = arr[i-1][j-1] + triangle[i][j];
                    continue;
                }
                arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-1]) + triangle[i][j];
            }
        }

        for (int i=0; i<arr.length; i++) {
            answer = Math.max(arr[arr.length - 1][i], answer);
        }

        return answer;
    }
}