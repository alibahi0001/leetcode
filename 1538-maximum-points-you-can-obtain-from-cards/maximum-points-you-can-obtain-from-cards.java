class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int sum=0;
        int maxsum=0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
            
        }
        maxsum=sum;
        int ptr=k-1;
        for(int i=n-1;i>n-1-k;i--)
        {
            sum= sum -arr[ptr--]+arr[i];
            maxsum=Math.max(sum,maxsum);
        }
        return maxsum;
    }
}