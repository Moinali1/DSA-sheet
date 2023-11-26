
class Solution
{
	static int idx=0;
    public static void convertToMaxHeapUtil(Node root)
    {
        ArrayList<Integer> order=new ArrayList<>();
		inorder(root,order);
		idx=order.size()-1;
		postorder(root,order);
    }
    
	public static void inorder(Node node,ArrayList<Integer> order)
	{
		if(node==null)return;
		inorder(node.left,order);
		order.add(node.data);
		inorder(node.right,order);
	}
	
	public static void postorder(Node node,ArrayList<Integer> order)
	{
		if(node==null || idx>order.size()-1)return;
		node.data=order.get(idx--);
		postorder(node.right,order);
		postorder(node.left,order);
	}
}



// class Solution
// {
//     //make index to be global to store the index value
//     static int index = 0;
//     public static void inorder(Node root,ArrayList<Integer> inarr){
//         if(root==null)return;
//         inorder(root.left,inarr);
//         inarr.add(root.data);
//         inorder(root.right,inarr);
//     }
//     public static void createMax(Node root,ArrayList<Integer> inarr){
//         if(root==null || index<0){
//             return;