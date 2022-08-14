class Solution {
    private List<List<String>> ans;
    private List<String> path;
    private Set<String> wordSet;
    private Map<String, Integer> dist;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>();
        for (String word: wordList) wordSet.add(word);
        dist = new HashMap<>();
        
        // BFS: Find the length of the stortest path
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        dist.put(beginWord, 1);
        while (!q.isEmpty()) {
            String word = q.poll();
            for (int i = 0; i < word.length(); ++i) {
                char[] temp = word.toCharArray();
                for (char j = 'a'; j <= 'z'; ++j) {
                    temp[i] = j;
                    String newStr = new String(temp);
                    if (wordSet.contains(newStr) && !dist.containsKey(newStr)) {
                        dist.put(newStr, dist.get(word) + 1);
                        if (newStr.equals(endWord)) break;
                        q.offer(newStr);
                    }
                    
                }
            }
        }
        System.out.println(dist.get(endWord));
        
        // DFS: Find the path in reverse order (endWord -> ... -> beginWord)
        ans = new ArrayList<>();
        if (!dist.containsKey(endWord)) return ans;
        path = new ArrayList<>();
        path.add(endWord);
        dfs(beginWord, endWord);
        return ans;
    }
    
    private void dfs(String beginWord, String curWord) {
        if (curWord.equals(beginWord)) {
            Collections.reverse(path);
            ans.add(new ArrayList(path));
            Collections.reverse(path);
            return;
        }
        for (int i = 0; i < curWord.length(); ++i) {
            char[] temp = curWord.toCharArray();
            for (char j = 'a'; j <= 'z'; ++j) {
                temp[i] = j;
                String newStr = new String(temp);
                if (dist.containsKey(newStr) && dist.get(newStr) == dist.get(curWord) - 1) {
                    path.add(newStr);
                    dfs(beginWord, newStr);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}