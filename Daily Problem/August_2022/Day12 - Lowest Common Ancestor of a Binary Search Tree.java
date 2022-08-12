/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int cur=root.val;
        if(cur<p.val && cur<q.val) return lowestCommonAncestor(root.right,p,q);
        if(cur>p.val && cur>q.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}

public static String caseSort(String str)
    {
        // Your code here
        String lower="", upper="", ans="";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a' && ch<='z'){
                lower+=ch;
            }else if(ch>='A' && ch<='Z'){
                upper+=ch;
            }
        }
        
        
        int i=0, j=0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a' && ch<='z'){
                ans+=lower.charAt(i);
                i++
            }else if(ch>='A' && ch<='Z'){
                h>='a' && ch<='z'){
                ans+=upper.charAt(j);
                j++
            }
        }
        return ans;
    }
