class Solution {
    public int arithmeticTriplets(int[] arr, int diff) {
        int c = 0;
        int n=arr.length;
        for(int i=1;i<n-1;i++){
            for(int j=i-1,k=i+1;j>=0 && k<n;){
                if(arr[i]-arr[j]==diff && arr[k]-arr[i]==diff){
                    System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    c++;
                    k++;
                    j--;
                }else if(arr[j]+arr[k]<2*arr[i]){
                    k++;
                }else{
                    j--;
                }
                // System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
            }
        }
        return c;
    }
}