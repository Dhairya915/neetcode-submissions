class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0 ; i<nums.length ; i++){
            int freq = map.getOrDefault(nums[i],0);
            map.put(nums[i],freq+1);
            if( freq + 1 > (nums.length/2)){
                return nums[i];
            }
        }

       return 0; 
    }
}