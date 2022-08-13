class Solution {
    // public static boolean check(char[] ch1, char[] ch2){
    //     if(ch1.length != ch2.length) return false;
    //     for(int i=0;i<ch1.length;i++){
    //         if(ch1[i] != ch2[i]) return false;
    //     }
    //     return true;
    // }
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String,Integer> nm=new LinkedHashMap<>();
        int a[]=new int[words.length];
        for(String p:words)
        {
            nm.put(p, nm.getOrDefault(p,0)+1);
        }
        int x=0;
        for(String p:nm.keySet())
        {
            a[x++]=nm.get(p);
        }
        int k=s.length(),c=words[0].length();
        for(int i=0;i<=k-((words.length*c));i++)
        {
            StringBuilder kk=new StringBuilder();
            kk.append(s.substring(i,i+(words.length*c)));
            int j;
            for(j=i;j<i+(words.length*c);j+=c)
            {
                if(nm.containsKey(s.substring(j,j+c)))
                {
                    if(nm.get(s.substring(j,j+c))>0)
                    {
                        nm.put(s.substring(j,j+c), nm.get(s.substring(j,j+c))-1);
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
            if(j==i+(words.length*c))
                list.add(i);
            j=0;
            for(String p:nm.keySet())
            {
                nm.put(p, a[j]);
                j++;
            }
        }
        
        // int range = words[0].length()*words.length;
        // HashMap<String, Integer> map = new HashMap<>();
        // for(String word: words){
        //     map.put(word, map.getOrDefault(word, 0)+1);
        // }
        // for(int i=0;i<words[0].length();i++){
        //     HashMap<String, Integer> m = new HashMap<>();
        //     int c=0, flag=0;
        //     for(int j=i;j<=s.length()-words[0].length();j+=words[0].length()){
        //         String sub = s.substring(j, j+words[0].length());
        //         if(!map.containsKey(sub)){
        //             m.clear();
        //             c=0;
        //             flag=0;
        //             i=j+words[0].length();
        //         }else{
        //             while(j-i == range || flag==1){
        //                 String left = s.substring(i, i+words[0].length());
        //                 i+=words[0].length();
        //                 m.put(left, m.get(left)-1);
        //                 if(m.get(left)>=map.get(left)){
        //                     flag=0;
        //                 }else{
        //                     c--;
        //                 }
        //             }
        //             m.put(sub, m.getOrDefault(sub, 0)+1);
        //             if(m.get(sub)>map.get(sub)){
        //                 flag=1;
        //             }else{
        //                 c++;
        //             }
        //             if(c==words.length && flag==0){
        //                 list.add(i);
        //             }
        //         }
        //     }
        // }
        
        // String word = "";
        // for(String st: words){
        //     word+=st;
        // }
        // char[] ch1 = word.toCharArray();
        // Arrays.sort(ch1);
        
        // int i=0, j=range-1;
        // while(j<s.length()){
        //     String str = s.substring(i, j+1);
        //     char[] ch2 = str.toCharArray();
        //     Arrays.sort(ch2);
        //     if(check(ch1, ch2) == true){
        //         list.add(i);
        //         i+= words[0].length();
        //         j+= words[0].length();
        //     }else{
        //         i+= words[0].length();
        //         j+= words[0].length();
        //     }
        // }
        
        return list;
    }
}