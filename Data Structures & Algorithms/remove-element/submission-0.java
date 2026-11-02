class Solution {
    public int removeElement(int[] nums, int val) {
        
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            if(nums[start] != val){
                start++;
            }
            else if(nums[start] == val){

               int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                end--;  
            }
        }
        return end+1;
    }
}