class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = (sum+nums[i]) % k;
            if(sum<0){
                sum+=k;
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }
            else{
                map.put(sum,1);
            }
        }
        int ans = 0;
        for(int key: map.keySet()){
            int n =map.get(key);
            if(n>=2){
                ans+=(n*(n-1))/2;
            }
        }
        return ans;

    }
}