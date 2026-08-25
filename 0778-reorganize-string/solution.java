import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if reorganization is possible
        for (int count : freq) {
            if (count > (s.length() + 1) / 2) {
                return "";
            }
        }

        // Max heap: character with highest frequency comes first
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        int[] previous = null;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            result.append((char) (current[0] + 'a'));
            current[1]--;

            // Put the previous character back after using another character
            if (previous != null && previous[1] > 0) {
                pq.offer(previous);
            }

            previous = current;
        }

        return result.toString();
    }
}
