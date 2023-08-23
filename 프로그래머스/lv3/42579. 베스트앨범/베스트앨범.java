import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> generesMap = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            List<Integer> tempList = generesMap.getOrDefault(genres[i], new ArrayList<>());
            tempList.add(i);
            generesMap.put(genres[i], tempList);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        List<Integer> answerList = new ArrayList<>();
        for (String str : list) {
            List<Integer> integerList = generesMap.get(str);
            integerList.sort((o1, o2) -> {
                if (plays[o1] == plays[o2]) {
                    return o1 - o2;
                }
                return plays[o2] - plays[o1];
            });
            if (integerList.size() < 2) {
                answerList.addAll(integerList);
            } else {
                answerList.add(integerList.get(0));
                answerList.add(integerList.get(1));
            }
        }
        answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}