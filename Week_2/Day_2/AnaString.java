import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String t) {

        List<Integer> ans = new ArrayList<>();

        int unmatchingCharCount = t.length();

        if (t.length() > s.length()) {
            return ans;
        }

        int[] freq = new int[26];

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            freq[index]++;
        }

        int start = 0;
        int end = 0;

        // First window
        for (; end < t.length(); end++) {
            int index = s.charAt(end) - 'a';

            if (freq[index] > 0) {
                unmatchingCharCount--;
            }

            freq[index]--;
        }

        if (unmatchingCharCount == 0) {
            ans.add(start);
        }

        // Sliding window
        for (; end < s.length(); end++) {

            int indexStart = s.charAt(start) - 'a';

            freq[indexStart]++;

            if (freq[indexStart] > 0) {
                unmatchingCharCount++;
            }

            start++;

            int indexEnd = s.charAt(end) - 'a';

            if (freq[indexEnd] > 0) {
                unmatchingCharCount--;
            }

            freq[indexEnd]--;

            if (unmatchingCharCount == 0) {
                ans.add(start);
            }
        }

        return ans;
    }
}
