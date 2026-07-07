package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // 記錄字元「最後一次」出現的索引
        Map<Character, Integer> lastCharMap = new HashMap<>();
        // 視窗的左邊界
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果這個字元曾經出現過，而且它的位置在目前的視窗範圍內 (>= left)
            if (lastCharMap.containsKey(c) && lastCharMap.get(c) >= left) {
                // 將左邊界移到「重複字元的下一個位置」
                left = lastCharMap.get(c) + 1;
            }
            lastCharMap.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
