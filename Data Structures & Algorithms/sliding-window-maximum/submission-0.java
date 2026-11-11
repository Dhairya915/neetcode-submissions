class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        int low = 0;
        int high = k-1;
        int max = Integer.MIN_VALUE;

        for(int i=0 ; i<k ; i++){
            max = Math.max(nums[i] , max);
        }

        res[0] = max;
        int pointer = 1;
        int prevMax = res[0];

        while(high < n-1){
            low++;
            high++;

            if(nums[high] == prevMax){
                res[pointer] = nums[high];
                pointer++;
                continue;
            }

            if(nums[high] > prevMax){
                res[pointer] = nums[high];
                prevMax = nums[high];
                pointer++;
                continue;
            }

            if(nums[high] < prevMax && prevMax == nums[low-1]){
                int maxVal = Integer.MIN_VALUE;
                for(int i=low ; i<=high ; i++){
                    maxVal = Math.max(maxVal,nums[i]);
                }
                res[pointer] = maxVal;
                prevMax = maxVal;
                pointer++;
                continue;
            }
            else{
                res[pointer] = prevMax;
                pointer++;
            }
        }
      return res;  
    }
}
