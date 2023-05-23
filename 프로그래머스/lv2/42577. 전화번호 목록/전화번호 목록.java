import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> hashSet = new HashSet<>(Arrays.asList(phone_book));
        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<phone_book[i].length(); j++) {
                if(hashSet.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}