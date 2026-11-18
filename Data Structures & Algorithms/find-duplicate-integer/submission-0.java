class Solution {
    public int findDuplicate(int[] nums) {
       int slow = 0;
       int fast = 0;
       int n = nums.length;

       do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        int idx = 0;
        while(idx != fast){
            idx = nums[idx];
            fast = nums[fast];
        }

        return idx;
        
    }
}
