class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;

        int[] freq = new int[128];

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            int index = letter;
            freq[index]++;
        }

        char[] arr = s.toCharArray();

        int minLow = 0;
        int minHigh = 0;
        int low = 0;
        int count = t.length();

        for (int high = 0; high < s.length(); high++) {
            int curr = arr[high];
            int index = curr;

            if (freq[index] > 0) {
                count--;
            }

            freq[index]--;

            while (count <= 0) {
                int len = high - low + 1;
                if (len < minLen) {
                    minLen = len;
                    minLow = low;
                    minHigh = high;  
                }

                int removed = arr[low] ;

                if (freq[removed] >= 0) {
                    count++;
                }

                freq[removed]++;
                low++;
            }
        }
        String res = s.substring(minLow , minHigh + 1);
        return minLen == Integer.MAX_VALUE ? "" : res;
    }
}
