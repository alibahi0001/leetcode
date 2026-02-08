class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer result=new StringBuffer("");
        int n1=word1.length();
        int n2=word2.length();
        int left=0;
        int right=0;
        for(int i=0;i<n1+n2;i++)
        {
            if(left<n1)
            {
                result.append(word1.charAt(left));
                left++;
            }
             if(right<n2)
            {
                result.append(word2.charAt(right));
                right++;
            }
        }
        return result.toString();
        
    }
}