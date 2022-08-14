class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = edges.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!map.containsKey(edges[i])){
                map.put(edges[i], i);
            }else{
                int num=map.get(edges[i])+i;
                map.put(edges[i], num);
            }
            
            if(map.containsKey(ans)){
                if(map.get(edges[i])>map.get(ans)){
                    ans = edges[i];
                }
                if(map.get(edges[i])==map.get(ans)){
                    if(edges[i]<ans) ans = edges[i];
                }
            }else{
                ans = edges[i];
            }
        }
        // int max = Integer.MIN_VALUE;
        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     if(max<entry.getValue()) max = entry.getValue();
        // }
        
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     if(max==entry.getValue()) arr.add(entry.getKey());
        // }
        
        // Collections.sort(arr);
        // return arr.get(0);
        // return ans;
    }
}