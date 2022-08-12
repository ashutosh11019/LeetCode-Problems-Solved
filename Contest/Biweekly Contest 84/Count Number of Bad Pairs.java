class Solution {
    public long countBadPairs(int[] nums) {
        long n=(long)nums.length;
        int c=0;
        for(int i=0;i<nums.length;i++){
            nums[i]-=i;
            if(nums[i]==0) c++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        long ans=0L;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            long num=(long)entry.getValue();
            if(num==2) ans+=1;
            else if(num>2){
                ans+=(num*(num-1))/2;
            }
        }
        long ans1 = (n*(n-1))/2;
        long res=ans1-ans;
        return res;
    }
}