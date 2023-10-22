import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        int[] nums = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        answer += Arrays.stream(nums)
            .min()
            .getAsInt() + " ";
        answer += Arrays.stream(nums)
            .max()
            .getAsInt();
        return answer;
    }
}