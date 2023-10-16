import java.util.Arrays;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int[] firstStickerDp = new int[sticker.length];
        int[] stickerDp = new int[sticker.length];
        firstStickerDp[0] = sticker[0];
        for (int i=1; i<sticker.length-1; i++) {
            if (i-2 < 0) {
                firstStickerDp[i] = Math.max(sticker[i], firstStickerDp[i-1]);
                continue;
            }
            firstStickerDp[i] = Math.max(firstStickerDp[i-2] + sticker[i], firstStickerDp[i-1]);
        }
        for (int i=1; i<sticker.length; i++) {
            if (i == 1) {
                stickerDp[i] = sticker[i];
                continue;
            }
            stickerDp[i] = Math.max(stickerDp[i-2] + sticker[i], stickerDp[i-1]);
        }
        answer = Math.max(Arrays.stream(firstStickerDp).max().getAsInt(), Arrays.stream(stickerDp).max().getAsInt());
        return answer;
    }
}