class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] freq = new int[26];
        int[] requires = new int[26];

        int match = 0;

        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = ch - 'a';
            requires[index]++;
        }

        for (int j = 0; j < n; j++) {
            char ch = s2.charAt(j);
            int index = ch - 'a';
            freq[index]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == requires[i]) {
                match++;
            }
        }

        if (match == 26) {
            return true;
        }

        int low = 0;
        int high = n - 1;

        while (high < s2.length() - 1) {
            char removed = s2.charAt(low);
            int idx = removed - 'a';

            if (freq[idx] == requires[idx]) {
                match--;
            }
            
            freq[idx]--;

            if (freq[idx] == requires[idx]) {
                match++;
            }

            low++;
            high++;

            char added = s2.charAt(high);
            int idx2 = added - 'a';
            if (freq[idx2] == requires[idx2]) {
                match--;
            }
            freq[idx2]++;

            if (freq[idx2] == requires[idx2]) {
                match++;
            }

            if (match == 26) {
                return true;
            }
        }

        return false;
    }
}
