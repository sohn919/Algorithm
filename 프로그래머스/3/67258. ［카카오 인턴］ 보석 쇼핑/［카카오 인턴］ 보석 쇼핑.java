import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        Set<String> duplicatedGems = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> mapGems = new HashMap<>();
        int start = 0;
        for (int end=0; end<gems.length; end++) {
            mapGems.put(gems[end], mapGems.getOrDefault(gems[end], 0) + 1);
            while (start <= end) {
                if (mapGems.size() != duplicatedGems.size()) {
                    break;
                }
                if (mapGems.get(gems[start]) == 1) {
                    mapGems.remove(gems[start]);
                } else {
                    mapGems.put(gems[start], mapGems.get(gems[start]) - 1);
                }
                validateAnswer(answer, start+1, end+1);
                start++;
            }
        }
        return answer;
    }

    private void validateAnswer(int[] answer, int start, int end) {
        int len = answer[1] - answer[0];
        int validateLen = end - start;
        if (len < validateLen) {
            return;
        }
        if (len == validateLen && answer[0] < start) {
            return;
        }
        answer[0] = start;
        answer[1] = end;
    }
}
// nlogn => 일반 탐색 + 이분 탐색