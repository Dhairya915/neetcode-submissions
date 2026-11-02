class Solution {
    public boolean isPalindrome(String s) {
        
        String data = s.toLowerCase();
        data = data.replaceAll("[^a-z0-9]", "");

        int left = 0; 
        int right = data.length() - 1;

        while(left < right){
            if(data.charAt(left) != data.charAt(right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
     return true;
    }
}
