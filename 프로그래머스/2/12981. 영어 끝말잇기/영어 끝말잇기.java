import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> duplicatedSet = new HashSet<>();
        char endChar = words[0].charAt(words[0].length() - 1);
        duplicatedSet.add(words[0]);
        int person = 2;
        for (int i=1; i<words.length; i++) {
            int size = duplicatedSet.size();
            duplicatedSet.add(words[i]);
            if (endChar != words[i].charAt(0)) {
                return new int[] {person, i / n + 1};
            }
            if (duplicatedSet.size() == size) {
                return new int[] {person, i / n + 1};
            }
            person = (person % n) + 1;
            endChar = words[i].charAt(words[i].length() - 1);
        }
        return answer;
    }
}