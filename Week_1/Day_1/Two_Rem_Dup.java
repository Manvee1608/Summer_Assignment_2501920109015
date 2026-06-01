class Solution {
    public int removeDuplicates(int[] nums) {
        if( nums.length==0)
        return 0;

        int uniPos=1;
        for (int cur=1; cur<nums.length;cur++){
            if (nums [cur]!= nums[cur-1]){
                nums[uniPos]= nums[cur];
                uniPos++;
            }
        }
        return uniPos;
    }
}
