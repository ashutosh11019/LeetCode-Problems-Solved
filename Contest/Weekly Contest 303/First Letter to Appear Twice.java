class Solution {
    public char repeatedCharacter(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                return ch;
                
            }
        }
        return 'a';
    }
}