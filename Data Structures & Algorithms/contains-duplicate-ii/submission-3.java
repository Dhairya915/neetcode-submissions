class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int low = 0;

        HashMap<Integer,Integer> hm = new HashMap<>();

        while(low < n){

            if(hm.containsKey(nums[low])){
                
                int prevIndex = hm.get(nums[low]);
                int diff = low - prevIndex ;
                
                if(diff <= k){
                    return true;
                }

                hm.replace(nums[low] , low);
            }
            else {
                hm.put(nums[low], low);
            }

            low++;
        }
        
        return false;
    }
}