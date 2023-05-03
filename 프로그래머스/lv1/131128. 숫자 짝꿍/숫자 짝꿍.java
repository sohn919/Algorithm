class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] arr = new int[10];
        for(int i=0; i<X.length(); i++) {
            xArr[X.charAt(i) - '0']++;
        }
        for(int i=0; i<Y.length(); i++) {
            if(xArr[Y.charAt(i) - '0'] > 0) {
                xArr[Y.charAt(i) - '0']--;
                arr[Y.charAt(i) - '0']++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            sb.append(Integer.toString(i).repeat(arr[i]));
        }
        if(sb.length() == 0)
            return "-1";
        if(sb.toString().charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}