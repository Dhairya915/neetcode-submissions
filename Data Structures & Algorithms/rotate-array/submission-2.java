class Solution {
    public void rotate(int[] nums, int k) {

        if(nums.length == 0){
            return;
        }

        int n = nums.length;
        if(k >= n){
            k = k % n;
        }

        if(k == 0){
            return;
        }


        ArrayList<Integer> list = new ArrayList<>();

        for(int i=n-k ; i<n ; i++){
            list.add(nums[i]);
        }

        

        for(int j = n-1 ; j>=k ; j--){
            nums[j] = nums[j-k];
            
        }

        int tempPointer = 0;

        for(int x=0 ; x<k ; x++){
            nums[x] = list.get(tempPointer);
            tempPointer++;
        }
    }
}