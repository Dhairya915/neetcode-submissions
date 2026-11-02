class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Track the minimum length found
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int low = 0;

        // high acts as the right bound of the sliding window
        for (int high = 0; high < nums.length; high++) {
            sum += nums[high];

            // Shrink the window from the left as long as the sum meets the target
            while (sum >= target) {
                minLen = Math.min(minLen, high - low + 1);
                sum -= nums[low];
                low++; // Move the left pointer forward
            }
        }

        // If minLen was updated, return it; otherwise, return 0
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}