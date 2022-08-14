class Solution {
    public String smallestNumber(String pattern) {
        String result = "";
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= pattern.length(); i++)
        {
            s.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I')
            {
                while (!s.empty())
                {
                    result += (s.peek());
                    s.pop();
                }
            }
        }
        return result;
    }
}