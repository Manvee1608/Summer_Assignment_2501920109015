class Solution {
    public int maxSubArray(int[] x)
    {
        int maxSum= x[0];
        int sum =x[0];
        for (int i =1;i<x.length;i++)
        {
            if (sum>=0)
            {
                sum+=x[i];
            }
            else
            {
                sum=x[i];
            }
            if(sum>maxSum)
            {
                 maxSum=sum;
            }

        }return maxSum;
        
    }
}
