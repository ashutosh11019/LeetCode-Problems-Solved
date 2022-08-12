class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int ans = 1;
        int width = grades[0];
        int c = 1;
        int c0=0;
        int cw=0;
        for (int i = 1; i < grades.length; i++)
        {
            cw += grades[i];
            c0 += 1;
            if (cw > width && c0 > c){
                width = cw;
                c = c0;
                cw = 0;
                c0 = 0;
                ans++;
            }
        }
      
        return ans;
    }
}