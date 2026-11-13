class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];

        arr[0] = 0;

        for(int i=1 ; i<=n ; i++){
            int res = 0;
            int k = i;
            while(k>0){
                res++;
                k = k & (k-1);
            }

            arr[i] = res;
        }

        return arr;
    }
}
