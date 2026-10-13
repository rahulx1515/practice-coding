class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        long sum=0;
        int n = nums.length;
        int[] arr = new int[n];

        for(int i=0; i<nums.length; i++){
            arr[i]=nums[i]*nums[i];

        
        }
        Arrays.sort(arr);
        int mid = n/2;
        for(int i =0; i<mid;i++){
            sum-=arr[i];

        }
        for(int i =mid; i<n; i++){
            sum+=arr[i];
        }
        return sum;
    }
}