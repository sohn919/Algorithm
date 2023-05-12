import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> arr;
        for(int i=0; i<commands.length; i++) {
            arr = list.subList(commands[i][0] - 1, commands[i][1]);
            answer[i] = arr.stream().sorted().collect(Collectors.toList())
                .get(commands[i][2] - 1);
        }               
        return answer;
    }
}