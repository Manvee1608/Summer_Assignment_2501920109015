class Solution{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count= queue.size();
List<Integer> tempList= new ArrayList<>();
while(count!=0){
    TreeNode temp=queue.remove();
    tempList.add(temp.val);
    if(temp.left!=null) queue.add(temp.left);
    if(temp.right!=null) queue.add(temp.right);
    count--;
}
ans.add(tempList);
        }
         return ans;
    }
}
