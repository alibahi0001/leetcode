class Solution {
    public String makeSmallestPalindrome(String s) {
        int n=s.length();
        StringBuffer str= new StringBuffer(s);
        int left=0;
        int right=n-1;
        while(left<right)
        {
            char top=s.charAt(left);
            char bottom=s.charAt(right);
            if(top==bottom)
            {
             left++;
             right--;
             continue; 
            }
            else{
                if(top<bottom)
                {
                     str.setCharAt(right,top);
                  
                    
                }
                else{
                    str.setCharAt(left,bottom);
                     
                }
            }
            left++;
            right--;
        }
      return str.toString();  
    }
}