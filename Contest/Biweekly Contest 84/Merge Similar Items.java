class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] item1, int[][] item2) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(item2, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
               if(first[0] > second[0]) return 1;
               else return -1;
            }
        });
        Arrays.sort(item1, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
               if(first[0] > second[0]) return 1;
               else return -1;
            }
        });
        int i=0, j=0;
        int n=item1.length, m=item2.length;
        while(i<n && j<m){
            if(item1[i][0]==item2[j][0]){
                int sum=item1[i][1]+item2[j][1];
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(item1[i][0]);
                sub.add(sum);
                list.add(sub);
                i++;
                j++;
            }else if(item1[i][0]>item2[j][0]){
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(item2[j][0]);
                sub.add(item2[j][1]);
                list.add(sub);
                j++;
            }else{
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(item1[i][0]);
                sub.add(item1[i][1]);
                list.add(sub);
                i++;
            }
        }
        while(i<n){
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(item1[i][0]);
            sub.add(item1[i][1]);
            list.add(sub);
            i++;
        }
        while(j<m){
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(item2[j][0]);
            sub.add(item2[j][1]);
            list.add(sub);
            j++;
        }
        return list;
    }
}