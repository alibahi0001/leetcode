class NumArray {
    int nums[];

    public NumArray(int[] nums) {
        this.nums=nums;
        
    }
    
    public int sumRange(int left, int right) {
        int n= nums.length;
        int rett=0;
        int[] ps =new int[n];
         
         int sum=0;
        for(int i=0;i<n;i++)
        {
        sum+=nums[i]; 
        ps[i]=sum;
        }
        if(left==0)
        {
            rett=ps[right];
        }
        else
        {
            rett=ps[right]-ps[left-1];
        }
        return rett;
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */