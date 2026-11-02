class Solution {
    public int[] productExceptSelf(int[] nums) {
        
       int num[] = new int[nums.length];

       //left side prefix array
       int left[] = new int[nums.length];
       left[0] = 1;
       for(int i=1 ; i<nums.length ; i++){
          left[i] = left[i-1] * nums[i-1];
       }

       //right side prefix array
       int right[] = new int[nums.length];
       right[nums.length-1] = 1;
       for(int i=nums.length-2 ; i>=0 ; i--){
          right[i] = right[i+1] * nums[i+1];
       }
    
       for(int k=0 ; k<num.length ; k++){
         num[k] = left[k] * right[k];
       }

      return num;
    }
}  
