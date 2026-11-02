class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        int left=0;
        int max_len = 0;

        for(int right=0; right<s.length() ; right++){

            if( map.containsKey(s.charAt(right)) && map.get(s.charAt(right))>=left ){
                left =  map.get(s.charAt(right))+1;
            }

            map.put( s.charAt(right) , right);
            max_len = Math.max(max_len , right-left+1);

        }
     return max_len;  
    }
}
