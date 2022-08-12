class Solution {
    static void dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj, int[] arr){
        vis[node]=1;
        for(int it: adj.get(node)){
            if(vis[it]==-1 && binarySearch(arr, it)==-1){
                dfs(it, vis, adj, arr);
            }
        }
    }
    
    static int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
    
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int vis[] = new int[n];
        Arrays.fill(vis, -1);
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // System.out.println(adj);
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(int num: restricted) arr.add(num);
        // Queue<Integer> q = new LinkedList<>();
        vis[0]=1;
        Arrays.sort(restricted);
        dfs(0, vis, adj, restricted);
        // q.add(0);
        // while(!q.isEmpty()){
        //     int num=q.poll();
        //     if(vis[num]==1){
        //         for(int node: adj.get(num)){
        //             if(vis[node]==1) continue;
        //             if(!arr.contains(node)) {
        //                 q.add(node);
        //                 vis[node]=1;
        //             }
        //         }
        //     }
        // }
        
        
//         vis[0]=1;
//         ArrayList<Integer> arr = new ArrayList<>();
//         for(int i=0;i<edges.length;i++){
//             if(edges[i][0]>edges[i][1]){
//                 int temp=edges[i][1];
//                 edges[i][1]=edges[i][0];
//                 edges[i][0]=temp;
//             }
//             // System.out.println(edges[i][0]+" "+edges[i][1]);
//         }
//         Arrays.sort(edges, new Comparator<int[]>() {
//             @Override
//             public int compare(int[] first, int[] second) {
//                if(first[0] > second[0]) return 1;
//                else return -1;
//             }
//         });
        
//         for(int num: restricted) arr.add(num);
        
//         for(int i=0;i<edges.length;i++){
//             if(edges[i][0]==0){
//                 if(!arr.contains(edges[i][1])){
//                     vis[edges[i][1]]=1;
//                 }
//             }else if(edges[i][1]==0){
//                 if(!arr.contains(edges[i][0])){
//                     vis[edges[i][0]]=1;
//                 }
//             }else{
//                 if(arr.contains(edges[i][0]) || arr.contains(edges[i][1])){
                    
//                 }else{
//                     if(vis[edges[i][0]]==1){
//                         vis[edges[i][1]]=1;
//                     }else if(vis[edges[i][1]]==1){
//                         vis[edges[i][0]]=1;
//                     }
//                 }
//             }
//         }
        
//         for(int i=0;i<edges.length;i++){
//             if(edges[i][0]==0){
//                 if(!arr.contains(edges[i][1])){
//                     vis[edges[i][1]]=1;
//                 }
//             }else if(edges[i][1]==0){
//                 if(!arr.contains(edges[i][0])){
//                     vis[edges[i][0]]=1;
//                 }
//             }else{
//                 if(arr.contains(edges[i][0]) || arr.contains(edges[i][1])){
                    
//                 }else{
//                     if(vis[edges[i][0]]==1){
//                         vis[edges[i][1]]=1;
//                     }else if(vis[edges[i][1]]==1){
//                         vis[edges[i][0]]=1;
//                     }
//                 }
//             }
//         }
        
        int c=0;
        for(int i=0;i<n;i++){
            if(vis[i]==1) {
                c++;
                System.out.println(i);
            }
        }
        return c;
    }
}